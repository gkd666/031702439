import java.util.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static Collection<String> damagedAddressBook = new ArrayList<String>();//用于存储每一条原始地址信息
	public static void main(String[] args) throws IOException{
		
	
	{	String inputpath=args[0];
    String outputpath=args[1];//获取输入输出文件参数
    FileInputStream fis = new FileInputStream(inputpath);
    InputStreamReader isr = new InputStreamReader(fis);
    @SuppressWarnings("resource")
	BufferedReader br = new BufferedReader(isr);
    String line = null;
    while ((line = br.readLine()) != null) {
        damagedAddressBook.add(line);
    }
    FileOutputStream fos = new FileOutputStream(outputpath);
    @SuppressWarnings("resource")
	OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");

	int count=0;	
	Iterator<String> it =damagedAddressBook.iterator();//创建迭代器
	osw.write("[");
    osw.flush();
		while (it.hasNext())//开始迭代
        {
		String s=it.next();
        
		
		String name,phone,p1,add1="",add2="",add3="",add4="",add5="",add6="",add7="";
		int f1=0,f2=0,f3=0,f4=0,f5=0,f6=0,f7=0,l=0,g=0;
		
		String[]s1=s.split("\\d{11}");
		p1=s.replace(s1[0],"");
		phone=p1.replace(s1[1],"");
	
		
		s=s1[0]+s1[1];
		int size=s.length();
		
		int n1=s.indexOf(",");
		name=s.substring(2,n1);		
		
		String sheng[]= {
				"北京",
				"天津",
				"上海",
				"重庆",
				"新疆",
				"宁夏",
				"广西",
				"内蒙",
				"西藏",
				"黑龙江",
				"河北",
				"河南",
				"云南",
				"辽宁",		
				"湖南",
				"安徽",
				"山东",				
				"江苏",
				"浙江",
				"江西",
				"湖北",				
				"甘肃",
				"山西",				
				"陕西",
				"吉林",
				"福建",
				"贵州",
				"广东",
				"青海",				
				"四川",				
				"海南",
				"台湾"};
		
		String city[]= {
			     "阿坝","阿拉善","阿里","安康","安庆","鞍山","安顺","安阳","澳门","B","北京","白银",

		            "保定","宝鸡","保山","包头","巴中","北海","蚌埠","本溪","毕节","滨州","百色","亳州",

		            "重庆","成都","长沙","长春","沧州","常德","昌都","长治","常州","巢湖","潮州","承德",

		            "郴州","赤峰","池州","崇左","楚雄","滁州","朝阳","大连","东莞","大理","丹东","大庆",

		            "大同","大兴安岭","德宏","德阳","德州","定西","迪庆","东营","鄂尔多斯","恩施","鄂州",

		            "福州","防城港","佛山","抚顺","抚州","阜新","阜阳","广州","桂林","贵阳","甘南",

		            "赣州","甘孜","广安","广元","贵港","果洛","杭州","哈尔滨","合肥","海口","呼和浩特",

		            "海北","海东","海南","海西","邯郸","汉中","鹤壁","河池","鹤岗","黑河","衡水","衡阳",

		            "河源","贺州","红河","淮安","淮北","怀化","淮南","黄冈","黄南","黄山","黄石","惠州",

		            "葫芦岛","呼伦贝尔","湖州","菏泽","济南","佳木斯","吉安","江门","焦作","嘉兴","嘉峪关",

		            "揭阳","吉林","金昌","晋城","景德镇","荆门","荆州","金华","济宁","晋中","锦州","九江",

		            "酒泉","昆明","开封","兰州","拉萨","来宾","莱芜","廊坊","乐山","凉山","连云港",

		            "聊城","辽阳","辽源","丽江","临沧","临汾","临夏","临沂","林芝","丽水","六安","六盘水",

		            "柳州","陇南","龙岩","娄底","漯河","洛阳","泸州","吕梁","马鞍山","茂名","眉山","梅州",

		            "绵阳","牡丹江","南京","南昌","南宁","宁波","南充","南平","南通","南阳","那曲","内江",

		            "宁德","怒江","盘锦","攀枝花","平顶山","平凉","萍乡","莆田","濮阳","青岛","黔东南",

		            "黔南","黔西南","庆阳","清远","秦皇岛","钦州","齐齐哈尔","泉州","曲靖","衢州","日喀则",

		            "日照","上海","深圳","苏州","沈阳","石家庄","三门峡","三明","三亚","商洛","商丘","上饶",

		            "山南","汕头","汕尾","韶关","绍兴","邵阳","十堰","朔州","四平","绥化","遂宁","随州","宿迁",

		            "宿州","天津","太原","泰安","泰州","台州","唐山","天水","铁岭","铜川","通化","通辽",

		            "铜陵","铜仁","台湾","武汉","乌鲁木齐","无锡","威海","潍坊","文山","温州","乌海","芜湖",

		            "乌兰察布","武威","梧州","厦门","西安","西宁","襄樊","湘潭","湘西","咸宁","咸阳","孝感",

		            "邢台","新乡","信阳","新余","忻州","西双版纳","宣城","许昌","徐州","香港","锡林郭勒","兴安",

		            "银川","雅安","延安","延边","盐城","阳江","阳泉","扬州","烟台","宜宾","宜昌","宜春",

		            "营口","益阳","永州","岳阳","榆林","运城","云浮","玉树","玉溪","玉林",

		            "枣庄","扎赉特旗",

		            "扎鲁特旗","张家港","张家界","张家口",

		            "张掖","漳州","湛江",

		            "肇庆","昭通",

		            "郑州","镇海区","镇江",

		            "中山",

		            "中卫","舟山",

		            "珠海","驻马店","准格尔旗","卓尼",

		            "株洲","淄博","自贡",

		            "资阳"

					};
	
		int i;
		for(i=0;i<sheng.length;i++)
		{	
			n1=s.indexOf(sheng[i]);
			if(n1!=-1&&(i==0||i==1||i==2||i==3))
			{	l=1;
				add1=s.substring(n1,n1+2);
				add2=add1+"市";
				f1=n1+2;
				break;
			}
			else if(n1!=-1&&i==4)
			{
				add1=s.substring(n1,n1+2);
				add1=add1+"维吾尔自治区";
				f1=n1+9;
				break;
			}
			else if(n1!=-1&&i==5)
			{
				add1=s.substring(n1,n1+2);
				add1=add1+"回族自治区";
				f1=n1+8;
				break;
			}
			else if(n1!=-1&&i==6)
			{
				add1=s.substring(n1,n1+2);
				add1=add1+"壮族自治区";
				f1=n1+8;
				break;
			}
			else if(n1!=-1&&i==7)
			{
				add1=s.substring(n1,n1+2);
				add1=add1+"古自治区";
				f1=n1+7;
				break;
			}
			else if(n1!=-1&&i==8)
			{
				add1=s.substring(n1,n1+2);
				add1=add1+"自治区";
				f1=n1+6;
				break;
			}
			else if(n1!=-1&&i!=8)
			{
				add1=s.substring(n1,n1+2);
				add1=add1+"省";
				break;
			}
			else if(n1!=-1&&i==9)
			{
				add1=s.substring(n1,n1+3);
				add1=add1+"省";		
				break;
			}
			
		}
		//
		int n;
		for(i=0;i<city.length;i++)
		{	
		
			n1=s.indexOf(city[i]);
			if(n1!=-1)
			{
				n=s.indexOf("市");
				if(n!=-1)
				{if(n1<n+1)
				{add2=s.substring(n1,n+1);
				 f2=n+1; 
				 break;
				}
				
				}
				else
				{add2=s.substring(n1,n1+2);
				 add2=add2+"市"; 
				 f2=n1+2;					
				 break;
				}
			}
			else
			f2=f1;
		}
		
		//
		n1=s.indexOf("区");
		if(n1!=-1&&f2<n1+1)
		{ 
			add3=s.substring(f2,n1+1);
			f3=n1+1;
		}
		else
		{	n1=s.indexOf("县");
			if(n1!=-1&&f2<n1+1)
			{add3=s.substring(f2,n1+1);
			f3=n1+1;
			}
			else
			f3=f2;
		}
		//
		n1=s.indexOf("街道");
		if(n1!=-1&&f3<n1+2)
		{
			add4=s.substring(f3,n1+2);
			f4=n1+2;
		}
		else
		{	n1=s.indexOf("镇");
			if(n1!=-1&&f3<n1+1)
			{
				add4=s.substring(f3,n1+1);
				f4=n1+1;
			}
			else
			{	n1=s.indexOf("乡");
				if(n1!=-1&&f3<n1+1)
				{
				add4=s.substring(f3,n1+1);
				f4=n1+1;
				}
				else
				f4=f3;
			}
		}
		//
		//
		
		int number=damagedAddressBook.size();
        int	f;
		f=s.indexOf("1");
		if(f!=0)
		{
		n1=s.indexOf("路");
		if(f4<n1+1)
		{
		add5=s.substring(f4,n1+1);
		f5=n1+1;
		}
		else
		f5=f4;
		//
		n1=s.indexOf("号");
		if(f5<n1+1)
		{
		add6=s.substring(f5,n1+1);
		f6=n1+1;
		}
		else
		f6=f5;
		//
		if(f6<size-1)
		{add7=s.substring(f6,size-1);}
		// 
		count++;
		 if(count!=number)
		 {
             osw.write("{\"姓名\":"+"\""+name+"\","+"\"手机\":"+"\""+phone+"\","+"\"地址\":"+"["
                     +"\""+add1+"\","+"\""+add2+"\","+"\""+add3+"\","+"\""+add4+"\","
                     +"\""+add5+"\","+"\""+add6+"\","+"\""+add7+"\"]},\r\n");
             osw.flush();
         }
         else{
        	 osw.write("{\"姓名\":"+"\""+name+"\","+"\"手机\":"+"\""+phone+"\","+"\"地址\":"+"["
                     +"\""+add1+"\","+"\""+add2+"\","+"\""+add3+"\","+"\""+add4+"\","
                     +"\""+add5+"\","+"\""+add6+"\","+"\""+add7+"\"]}]");
             osw.flush();
	    }
		}
		else
		{	if(f4<size-1)
			{add5=s.substring(f4,size-1);}
		  	
		count++;
          if(count!=number){
        	  
              osw.write("{\"姓名\":"+"\""+name+"\","+"\"手机\":"+"\""+phone+"\","+"\"地址\":"+"["
                      +"\""+add1+"\","+"\""+add2+"\","+"\""+add3+"\","+"\""+add4+"\","
                      +"\""+add5+"\"]},\r\n");
              osw.flush();
          }
          else{
        	  osw.write("{\"姓名\":"+"\""+name+"\","+"\"手机\":"+"\""+phone+"\","+"\"地址\":"+"["
                      +"\""+add1+"\","+"\""+add2+"\","+"\""+add3+"\","+"\""+add4+"\","
                      +"\""+add5+"\"]}]");
              osw.flush();
          }
		
		}
        }
	}	
	}
		
}
