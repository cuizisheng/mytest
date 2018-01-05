package cn.itcast.web.action;



import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes.Name;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.Dispatcher;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

@ParentPackage(value="struts-default")
@Namespace(value="/")
public class MyAction extends ActionSupport{
	private String Name="cuizisheng";
	
	public String getName(){
		return this.Name;
	}

	@Override
	public String execute() throws Exception {
		Dispatcher dispatcher = Dispatcher.getInstance();
		System.out.println(dispatcher);
		return SUCCESS;
	}
	
	@Action(value="MyAction",results={@Result(name="success",location="/index.jsp")})
	public String findAllCustomer(){
		
		ActionContext context = ActionContext.getContext();
		ValueStack valueStack = context.getValueStack();
		Map<String, Object> context2 = valueStack.getContext();
		Set<String> keySet = context2.keySet();
		for (String string : keySet) {
			System.out.println(string);
		}
		
		return "success";
	}
	
}
