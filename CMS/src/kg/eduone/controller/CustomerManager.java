package kg.eduone.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import kg.eduone.vo.Customer;

public class CustomerManager {
	// 멤버
	private boolean isStop;
	private BufferedReader br;
	private ArrayList<Customer> data;
	private int position;
	
	// 생성자
	public CustomerManager() {
		isStop = false;
		br = new BufferedReader(new InputStreamReader(System.in));
		data = new ArrayList<Customer>();
		position = -1;
	}	// end CutomerManager()
	
	// 메서드 (기능 구현)
	public void start() throws IOException {
		int menu = -1;
		
		while(!isStop) {	// 처음 실행했을 때 화면
			System.out.println("1.고객등록");
			System.out.println("2.고객검색");
			System.out.println("3.고객정보수정");
			System.out.println("4.고객정보삭제");
			System.out.println("5.고객전체목록보기");
			System.out.println("0.프로그램종료");
			System.out.print("메뉴선택 : ");
			
			try {	// 예외 (숫자가 아닌 값이 입력받으면 예외처리)
				menu = Integer.parseInt(br.readLine());
			} catch (NumberFormatException nfe){
				menu = -1;
			}	// end try ~ catch
			
			switch(menu) {	// case마다 메서드를 참조
			case 1: addCustomer(); break;
			case 2: search(); break;
			case 3: updateCustomer(); break;
			case 4: deleteCustomer(); break;
			case 5: display(); break;
			case 0: stop(); break;
				default:
					System.err.println("\n메뉴입력오류 : 메뉴를 확인하시고 다시 입력해 주세요^^;");
					break;
			}	// end switch(menu)
		}	// end while(!isStop)
	}	// end void start() throws IOException
	private void stop() throws IOException {
		System.out.println();
		System.out.print("정말로 프로그램을 종료하시겠습니까? (y/n) : ");
		String result = br.readLine();
		if(result.contentEquals("Y") || result.contentEquals("y")) {
			System.out.println("프로그램을 종료합니다.");
			isStop = true;	// while문을 통해 종료
		} else {
			System.out.println("프로그램 종료를 취소합니다.");
			isStop = false;	// while문에 의해 종료가 되지는 않고 start 메서드가 다시 실행됨
		}	// end if ~ else
	}	// end void stop() throws IOException
	private void addCustomer() throws IOException {
		System.out.println();
		System.out.print("고객 이름 : ");
		String name = br.readLine();
		
		System.out.print("나이 : ");
		int age = Integer.parseInt(br.readLine());
		
		System.out.print("전화번호 : ");
		String tel = br.readLine();
		
		System.out.print("주소 : ");
		String address = br.readLine();
		
		Customer myCustomer = new Customer(name, age, tel, address);
		// Customer라는 클래스는 myCustomer라는 이름으로 객체를 생성
		// (name, age, tel, address) 네 가지 값 저장
		data.add(myCustomer);	// myCustomer에 입력 된 값을 추가
		System.out.println("회원등록이 성공적으로 완료되었습니다.\n");
	}	// end void addCustomer() throws IOException
	private void search() throws IOException {
		System.out.println();
		System.out.print("찾으시는 회원이름 : ");
		String name = br.readLine();
		
		position = -1;	// position의 값을 -1로 초기화
		
		for(int i = 0; i < data.size(); i++) {	// data가 들어있는 갯수 만큼 반복문 실행
			Customer myCustomer = data.get(i);	// data에서 i의 값의 position에 있는 값을 가져옴
			if(name.contentEquals(myCustomer.getName())) {	// 그 position의 값중에 이름이랑 입력 받은 이름이 같은지 비교
				position = i;	// 같으면 position에 그 position의 값을 입력
				break;
			}	// end if(name.contentEquals(myCustomer.getName()))
		}	// end for i
		if(position < 0) {	// 단순 설명 출력문
			System.out.println(name + "님은 저희 회원이 아닙니다. 고객등록을 하세요^^;");
		} else {
			System.out.println(name + "님의 정보검색 성공");
		}	// end if ~ else
	}	// end void search() throws IOException
	private void updateCustomer() throws IOException {
		System.out.println();
		if(position < 0) {
			System.err.println("수정할 고객 정보를 먼저 검색하셔야 합니다^^;");
			return;
		}	// end if(position < 0)
		Customer myCustomer = data.get(position);
		
		int menu = -1;
		boolean isLoop = false;
		
		while(!isLoop) {
			System.out.println(myCustomer.getName() + "님의 정보수정.");
			System.out.println("1. 전화번호수정");
			System.out.println("2. 주소수정");
			System.out.println("0. 수정취소");
			System.out.print("메뉴 선택 : ");
			try {
				menu = Integer.parseInt(br.readLine());
			} catch (NumberFormatException nfe) {
				menu = -1;
			}	// end try ~ catch
			switch(menu) {
			case 1:
				System.out.print("\n수정할 전화번호 : ");
				String imsiTel = br.readLine();
				myCustomer.setTel(imsiTel);	// position값에 의해서 가져온 데이터 값중 Tel값에 imsiTel값을 입력
				System.out.println("전화번호가 성공적으로 수정되었습니다.");
				isLoop = false;	// 계속 while문을 실행
				break;
			case 2:
				System.out.print("\n수정할 주소 : ");
				String imsiAddr = br.readLine();
				myCustomer.setAddress(imsiAddr);	// position값에 의해서 가져온 데이터 값중 Address값에 imsiAddr값을 입력
				System.out.println("주소가 성공적으로 수정되었습니다.");
				isLoop = false;	// 계속 while문을 실행
				break;
			case 0:
				System.out.println("\n" + myCustomer.getName() + "님의 정보수정을 취소합니다.");
				isLoop = true;	// 계속 while문을 실행
				break;
			default:
				System.out.println("\n메뉴입력오류 : 메뉴를 확인하시고 다시 입력해주세요^^;");
				isLoop = true;	// while문 실행을 정지
				break;
			}
		}	// end while(!isLoop)
	}	// end void updateCustomer() throws IOException
	private void deleteCustomer() throws IOException {
		System.out.println();
		if(position < 0) {
			System.err.println("삭제할 고객 정보를 먼저 검색하셔야 합니다^^;");
			return;
		}	// end if(position < 0)
		Customer myCustomer = data.get(position);
		
		System.out.print(myCustomer.getName() + "님의 정보를 정말로 삭제하시겠습니까? (y/n) : ");
		String result = br.readLine();
		if(result.contentEquals("Y") || result.contentEquals("y")) {
			System.out.println(myCustomer.getName() + "님의 정보삭제 성공.");
			data.remove(position);	// position값을 통해 그 position에 있는 data를 삭제
			position = -1;	// position값을 -1로 초기화
		} else {
			System.out.println(myCustomer.getName() + "님의 정보삭제를 취소합니다.");
		}	// end if ~ else
	}	// end void deleteCustomer() throws IOException
	private void display() {
		System.out.println();
		for(Customer myCustomer : data) {
			System.out.println(myCustomer.toString());
		}	// end for(Customer myCustomer : data)
		System.out.println();
	}	// end void display()

	// 메인 메서드
	public static void main(String[] args) {
		CustomerManager manager = new CustomerManager();
		try {
			manager.start();	// start 메서드 실행
		} catch (IOException e) {
			e.printStackTrace();
		}	// end try ~ catch
	}	// end void main(String[] args)
}	// end class CustomerManager