package Vo;

public class StockVo {
	private String material_Id;
	private String material_Name;
	private String Count;

	public String getMaterial_Id() {
		return material_Id;
	}

	public void setMaterial_Id(String material_Id) {
		this.material_Id = material_Id;
	}

	public String getMaterial_Name() {
		return material_Name;
	}

	public void setMaterial_Name(String material_Name) {
		this.material_Name = material_Name;
	}

	public String getCount() {
		return Count;
	}

	public void setCount(String count) {
		Count = count;
	}

	public String getSHELF_LIFE() {
		return SHELF_LIFE;
	}

	public void setSHELF_LIFE(String sHELF_LIFE) {
		SHELF_LIFE = sHELF_LIFE;
	}

	private String SHELF_LIFE;

}