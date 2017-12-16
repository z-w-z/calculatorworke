package cn.itcast.web.struts2.worke;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;


public class CalculatorAction extends ActionSupport{
	private Integer num1;//操作数一
	private String opt;//操作符号
	private int num2;//操作数二
	private int result;//结果
	private String equ = "=";//等号
	
	public Integer getNum1() {
		return num1;
	}
	public void setNum1(Integer num1) {
		this.num1 = num1;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getEqu() {
		return equ;
	}
	public void setEqu(String equ) {
		this.equ = equ;
	}
	
	public void validateExecute(){
		String strNum1 = this.num1+"";
		String strNum2 = this.num2+"";
		if(strNum1!=null&&strNum1.trim().length()>0){
			if(strNum1.matches("^[0-9]{0,4}")){
				
			}else{
				this.addFieldError("num1","操作数一必须是四位数");
			}
		}else{
			this.addFieldError("num1","操作数一必填");
		}
		if(strNum2!=null&&strNum2.trim().length()>0){
			if(strNum2.matches("^[0-9]{0,4}")){
				
			}else{
				this.addFieldError("num2","操作数二必须是四位数");
			}
		}else{
			this.addFieldError("num2","操作数二必填");
		}
	}
	public String execute() throws Exception{
		ActionContext.getContext().put("flag","showResult");
		if(this.opt.equals("+")){
			this.result = this.num1 + this.num2;	
		}else if(this.opt.equals("-")){
			this.result = this.num1 - this.num2;
		}else if(this.opt.equals("*")){
			this.result = this.num1 * this.num2;
		}else if(this.opt.equals("/")){
			if(this.num2!=0){
				this.result = this.num1 / this.num2;
			}else{
				ActionContext.getContext().put("message","除数不能为0");
			}
		}
		
		return this.SUCCESS;
	
	}

}
