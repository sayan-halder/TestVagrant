import java.util.*;
class Basket
{
	String product;
	double unit_price;
	double unit_price_gst;
	double quantity;
	Basket(String product, double unit_price, double gst, double quantity)
	{
		this.product = product;

		if(unit_price >= 500)
		{
			this.unit_price = unit_price - (unit_price * 0.05);
		}
		else
		{
			this.unit_price = unit_price;
		}

		this.unit_price_gst = this.unit_price + (this.unit_price * (gst / 100));

		this.quantity = quantity;

	}
}

public class ShoppingCart
{
	public static void main(String[] args)
	{
		ArrayList<Basket> lst = new ArrayList<Basket>();
		Basket item1 = new Basket("Leather wallet", 1100, 18, 1);
		Basket item2 = new Basket("Umbrella", 900, 12, 4);
		Basket item3 = new Basket("Cigarette", 200, 28, 3);
		Basket item4 = new Basket("Honey", 100, 0, 2);
		lst.add(item1);
		lst.add(item2);
		lst.add(item3);
		lst.add(item4);

		ShoppingCart obj = new ShoppingCart();
		obj.maximumGstAmount(lst);
	}

	public void maximumGstAmount(ArrayList<Basket> lst)
	{
		double total_price = 0;
		double max_gst = 0;
		String max_gst_product = "";
		for(Basket i : lst)
		{
			total_price += i.unit_price_gst * i.quantity;
			max_gst = Math.max(max_gst, ((i.unit_price_gst * i.quantity) - (i.unit_price * i.quantity)));
			if(max_gst == ((i.unit_price_gst * i.quantity) - (i.unit_price * i.quantity)))
			{
				max_gst_product = i.product;
			}
		}

		System.out.println("\nThe product for which we paid maximum GST amount is: "+max_gst_product);
		System.out.println("\nThe total amount to be paid to the shop-keeper is: "+total_price);
	}
}