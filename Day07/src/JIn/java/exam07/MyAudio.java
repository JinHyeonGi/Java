package JIn.java.exam07;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class MyAudio extends Frame implements ActionListener{
   //멤버
   private String[] str = {"play", "stop", "loop"};
   private Button[] bt = new Button[str.length];
   private AudioClip audio;
   //생성자
   public MyAudio(){
      try{
         audio = Applet.newAudioClip(getClass().getResource("image/spacemusic.au"));
      }catch(Exception e){  }
      setLayout(new GridLayout(1,3,3,3));
      for(int i=0; i<bt.length; i++){
         bt[i] = new Button(str[i]);
         bt[i].setFont(new Font("Impact", Font.BOLD, 30));
         bt[i].addActionListener(this);
         add(bt[i]);
      }
      setSize(300,200);
      setVisible(true);
   }
   //매서드
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == bt[0]){
         try{
            audio.play();
         }catch(Exception ee){  }
      }
      if(e.getSource() == bt[1]){
         try{
            audio.stop();
         }catch(Exception ee){  }
      }
      if(e.getSource() == bt[2]){
         try{
            audio.loop();
         }catch(Exception ee){  }
      }
   }
   public static void main(String[] ar){
      new MyAudio();
   }
}