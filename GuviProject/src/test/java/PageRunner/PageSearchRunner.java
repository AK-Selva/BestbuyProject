package PageRunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import DriverSetup.BrowserSetup;
import Pages.PageSearch;
import java.util.*;
public class PageSearchRunner extends BrowserSetup{

	PageSearch page=null;
	
	@Test(priority=1)
	public void SearchData() throws InterruptedException
	{
		page=new  PageSearch(webDriver);
		String result=page.SearchBox();
		Assert.assertEquals(result, "laptop - Best Buy","Searched data Title is not correct");
	}
	@Test(priority=2)
	public void AddToCart() throws InterruptedException
	{
		page=new  PageSearch(webDriver);
		List<String> Items = new ArrayList<>();
	//	int count=Items.size();
		Items=page.AddToCart(Items);
//		int countadded= Items.size();
//		if(countadded>count)
//			System.out.println("items added to Cart");
		
		page.ShopbyDepartment();
	}
	
}
