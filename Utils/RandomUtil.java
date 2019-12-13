package com.DemoAll.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

/**
 * 随机种子工具类
 * 
 * @author Lychie Fan
 */
public class RandomUtil {
	
	private static long count = 1;
	private static final String place[][] = {{"北京", "市辖区", "市辖县"},
			{"天津", "市辖区", "市辖县"},
			{"安徽", "安庆市", "蚌埠市", "亳州市", "巢湖市", "池州市", "滁州市", "阜阳市", "合肥市",
					"淮北市", "淮南市", "黄山市", "六安市", "马鞍山市", "宿州市", "铜陵市", "芜湖市",
					"宣城市"},
			{"澳门", "澳门"}, {"香港", "香港"},
			{"福建", "福州市", "龙岩市", "南平市", "宁德市", "莆田市", "泉州市", "厦门市", "漳州市"},
			{"甘肃", "白银市", "定西市", "甘南藏族自治州", "嘉峪关市", "金昌市", "酒泉市", "兰州市",
					"临夏回族自治州", "陇南市", "平凉市", "庆阳市", "天水市", "武威市", "张掖市"},
			{"广东", "潮州市", "东莞市", "佛山市", "广州市", "河源市", "惠州市", "江门市", "揭阳市",
					"茂名市", "梅州市", "清远市", "汕头市", "汕尾市", "韶关市", "深圳市", "阳江市",
					"云浮市", "湛江市", "肇庆市", "中山市", "珠海市"},
			{"广西", "百色市", "北海市", "崇左市", "防城港市", "贵港市", "桂林市", "河池市", "贺州市",
					"来宾市", "柳州市", "南宁市", "钦州市", "梧州市", "玉林市"},
			{"贵州", "安顺市", "毕节地区", "贵阳市", "六盘水市", "黔东南苗族侗族自治州", "黔南布依族苗族自治州",
					"黔西南布依族苗族自治州", "铜仁地区", "遵义市"},
			{"海南", "海口市", "三亚市", "省直辖县级行政区划"},
			{"河北", "保定市", "沧州市", "承德市", "邯郸市", "衡水市", "廊坊市", "秦皇岛市", "石家庄市",
					"唐山市", "邢台市", "张家口市"},
			{"河南", "安阳市", "鹤壁市", "焦作市", "开封市", "洛阳市", "漯河市", "南阳市", "平顶山市",
					"濮阳市", "三门峡市", "商丘市", "新乡市", "信阳市", "许昌市", "郑州市", "周口市",
					"驻马店市"},
			{"黑龙江", "大庆市", "大兴安岭地区", "哈尔滨市", "鹤岗市", "黑河市", "鸡西市", "佳木斯市",
					"牡丹江市", "七台河市", "齐齐哈尔市", "双鸭山市", "绥化市", "伊春市"},
			{"湖北", "鄂州市", "恩施土家族苗族自治州", "黄冈市", "黄石市", "荆门市", "荆州市", "十堰市",
					"随州市", "武汉市", "咸宁市", "襄樊市", "孝感市", "宜昌市"},
			{"湖南", "长沙市", "常德市", "郴州市", "衡阳市", "怀化市", "娄底市", "邵阳市", "湘潭市",
					"湘西土家族苗族自治州", "益阳市", "永州市", "岳阳市", "张家界市", "株洲市"},
			{"吉林", "白城市", "白山市", "长春市", "吉林市", "辽源市", "四平市", "松原市", "通化市",
					"延边朝鲜族自治州"},
			{"江苏", "常州市", "淮安市", "连云港市", "南京市", "南通市", "苏州市", "宿迁市", "泰州市",
					"无锡市", "徐州市", "盐城市", "扬州市", "镇江市"},
			{"江西", "抚州市", "赣州市", "吉安市", "景德镇市", "九江市", "南昌市", "萍乡市", "上饶市",
					"新余市", "宜春市", "鹰潭市"},
			{"辽宁", "鞍山市", "本溪市", "朝阳市", "大连市", "丹东市", "抚顺市", "阜新市", "葫芦岛市",
					"锦州市", "辽阳市", "盘锦市", "沈阳市", "铁岭市", "营口市"},
			{"内蒙古", "阿拉善盟", "巴彦淖尔市", "包头市", "赤峰市", "鄂尔多斯市", "呼和浩特市", "呼伦贝尔市",
					"通辽市", "乌海市", "乌兰察布市", "锡林郭勒盟", "兴安盟"},
			{"宁夏", "固原市", "石嘴山市", "吴忠市", "银川市", "中卫市"},
			{"青海", "果洛藏族自治州", "海北藏族自治州", "海东地区", "海南藏族自治州", "海西蒙古族藏族自治州",
					"黄南藏族自治州", "西宁市", "玉树藏族自治州"},
			{"山东", "滨州市", "德州市", "东营市", "菏泽市", "济南市", "济宁市", "莱芜市", "聊城市",
					"临沂市", "青岛市", "日照市", "泰安市", "威海市", "潍坊市", "烟台市", "枣庄市",
					"淄博市"},
			{"山西", "长治市", "大同市", "晋城市", "晋中市", "临汾市", "吕梁市", "朔州市", "太原市",
					"忻州市", "阳泉市", "运城市"},
			{"陕西", "安康市", "宝鸡市", "汉中市", "商洛市", "铜川市", "渭南市", "西安市", "咸阳市",
					"延安市", "榆林市"},
			{"四川", "阿坝藏族羌族自治州", "巴中市", "成都市", "达州市", "德阳市", "甘孜藏族自治州", "广安市",
					"广元市", "乐山市", "凉山彝族自治州", "泸州市", "眉山市", "绵阳市", "内江市", "南充市",
					"攀枝花市", "遂宁市", "雅安市", "宜宾市", "资阳市", "自贡市"},
			{"西藏", "阿里地区", "昌都地区", "拉萨市", "林芝地区", "那曲地区", "日喀则地区", "山南地区"},
			{"新疆", "阿克苏地区", "阿勒泰地区", "巴音郭楞蒙古自治州", "博尔塔拉蒙古自治州", "昌吉回族自治州",
					"哈密地区", "和田地区", "喀什地区", "克拉玛依市", "克孜勒苏柯尔克孜自治州", "塔城地区",
					"吐鲁番地区", "乌鲁木齐市", "伊犁哈萨克自治州", "自治区直辖县级行政区划"},
			{"云南", "保山市", "楚雄彝族自治州", "大理白族自治州", "德宏傣族景颇族自治州", "迪庆藏族自治州",
					"红河哈尼族彝族自治州", "昆明市", "丽江市", "临沧市", "怒江僳僳族自治州", "普洱市", "曲靖市",
					"文山壮族苗族自治州", "西双版纳傣族自治州", "玉溪市", "昭通市"},
			{"浙江", "杭州市", "湖州市", "嘉兴市", "金华市", "丽水市", "宁波市", "衢州市", "绍兴市",
					"台州市", "温州市", "舟山市"},
			{"重庆", "市辖区", "市辖县", "县级市"},
			{"台湾", "台北市", "高雄市", "基隆市", "台中市", "台南市", "新竹市", "嘉义市"},};
	private static String[] road = "重庆大厦,黑龙江路,十梅庵街,遵义路,湘潭街,瑞金广场,仙山街,仙山东路,仙山西大厦,白沙河路,赵红广场,机场路,民航街,长城南路,流亭立交桥,虹桥广场,长城大厦,礼阳路,风岗街,中川路,白塔广场,兴阳路,文阳街,绣城路,河城大厦,锦城广场,崇阳街,华城路,康城街,正阳路,和阳广场,中城路,江城大厦,顺城路,安城街,山城广场,春城街,国城路,泰城街,德阳路,明阳大厦,春阳路,艳阳街,秋阳路,硕阳街,青威高速,瑞阳街,丰海路,双元大厦,惜福镇街道,夏庄街道,古庙工业园,中山街,太平路,广西街,潍县广场,博山大厦,湖南路,济宁街,芝罘路,易州广场,荷泽四路,荷泽二街,荷泽一路,荷泽三大厦,观海二广场,广西支街,观海一路,济宁支街,莒县路,平度广场,明水路,蒙阴大厦,青岛路,湖北街,江宁广场,郯城街,天津路,保定街,安徽路,河北大厦,黄岛路,北京街,莘县路,济南街,宁阳广场,日照街,德县路,新泰大厦,荷泽路,山西广场,沂水路,肥城街,兰山路,四方街,平原广场,泗水大厦,浙江路,曲阜街,寿康路,河南广场,泰安路,大沽街,红山峡支路,西陵峡一大厦,台西纬一广场,台西纬四街,台西纬二路,西陵峡二街,西陵峡三路,台西纬三广场,台西纬五路,明月峡大厦,青铜峡路,台西二街,观音峡广场,瞿塘峡街,团岛二路,团岛一街,台西三路,台西一大厦,郓城南路,团岛三街,刘家峡路,西藏二街,西藏一广场,台西四街,三门峡路,城武支大厦,红山峡路,郓城北广场,龙羊峡路,西陵峡街,台西五路,团岛四街,石村广场,巫峡大厦,四川路,寿张街,嘉祥路,南村广场,范县路,西康街,云南路,巨野大厦,西江广场,鱼台街,单县路,定陶街,滕县路,钜野广场,观城路,汶上大厦,朝城路,滋阳街,邹县广场,濮县街,磁山路,汶水街,西藏路,城武大厦,团岛路,南阳街,广州路,东平街,枣庄广场,贵州街,费县路,南海大厦,登州路,文登广场,信号山支路,延安一街,信号山路,兴安支街,福山支广场,红岛支大厦,莱芜二路,吴县一街,金口三路,金口一广场,伏龙山路,鱼山支街,观象二路,吴县二大厦,莱芜一广场,金口二街,海阳路,龙口街,恒山路,鱼山广场,掖县路,福山大厦,红岛路,常州街,大学广场,龙华街,齐河路,莱阳街,黄县路,张店大厦,祚山路,苏州街,华山路,伏龙街,江苏广场,龙江街,王村路,琴屿大厦,齐东路,京山广场,龙山路,牟平街,延安三路,延吉街,南京广场,东海东大厦,银川西路,海口街,山东路,绍兴广场,芝泉路,东海中街,宁夏路,香港西大厦,隆德广场,扬州街,郧阳路,太平角一街,宁国二支路,太平角二广场,天台东一路,太平角三大厦,漳州路一路,漳州街二街,宁国一支广场,太平角六街,太平角四路,天台东二街,太平角五路,宁国三大厦,澳门三路,江西支街,澳门二路,宁国四街,大尧一广场,咸阳支街,洪泽湖路,吴兴二大厦,澄海三路,天台一广场,新湛二路,三明北街,新湛支路,湛山五街,泰州三广场,湛山四大厦,闽江三路,澳门四街,南海支路,吴兴三广场,三明南路,湛山二街,二轻新村镇,江南大厦,吴兴一广场,珠海二街,嘉峪关路,高邮湖街,湛山三路,澳门六广场,泰州二路,东海一大厦,天台二路,微山湖街,洞庭湖广场,珠海支街,福州南路,澄海二街,泰州四路,香港中大厦,澳门五路,新湛三街,澳门一路,正阳关街,宁武关广场,闽江四街,新湛一路,宁国一大厦,王家麦岛,澳门七广场,泰州一路,泰州六街,大尧二路,青大一街,闽江二广场,闽江一大厦,屏东支路,湛山一街,东海西路,徐家麦岛函谷关广场,大尧三路,晓望支街,秀湛二路,逍遥三大厦,澳门九广场,泰州五街,澄海一路,澳门八街,福州北路,珠海一广场,宁国二路,临淮关大厦,燕儿岛路,紫荆关街,武胜关广场,逍遥一街,秀湛四路,居庸关街,山海关路,鄱阳湖大厦,新湛路,漳州街,仙游路,花莲街,乐清广场,巢湖街,台南路,吴兴大厦,新田路,福清广场,澄海路,莆田街,海游路,镇江街,石岛广场,宜兴大厦,三明路,仰口街,沛县路,漳浦广场,大麦岛,台湾街,天台路,金湖大厦,高雄广场,海江街,岳阳路,善化街,荣成路,澳门广场,武昌路,闽江大厦,台北路,龙岩街,咸阳广场,宁德街,龙泉路,丽水街,海川路,彰化大厦,金田路,泰州街,太湖路,江西街,泰兴广场,青大街,金门路,南通大厦,旌德路,汇泉广场,宁国路,泉州街,如东路,奉化街,鹊山广场,莲岛大厦,华严路,嘉义街,古田路,南平广场,秀湛路,长汀街,湛山路,徐州大厦,丰县广场,汕头街,新竹路,黄海街,安庆路,基隆广场,韶关路,云霄大厦,新安路,仙居街,屏东广场,晓望街,海门路,珠海街,上杭路,永嘉大厦,漳平路,盐城街,新浦路,新昌街,高田广场,市场三街,金乡东路,市场二大厦,上海支路,李村支广场,惠民南路,市场纬街,长安南路,陵县支街,冠县支广场,小港一大厦,市场一路,小港二街,清平路,广东广场,新疆路,博平街,港通路,小港沿,福建广场,高唐街,茌平路,港青街,高密路,阳谷广场,平阴路,夏津大厦,邱县路,渤海街,恩县广场,旅顺街,堂邑路,李村街,即墨路,港华大厦,港环路,馆陶街,普集路,朝阳街,甘肃广场,港夏街,港联路,陵县大厦,上海路,宝山广场,武定路,长清街,长安路,惠民街,武城广场,聊城大厦,海泊路,沧口街,宁波路,胶州广场,莱州路,招远街,冠县路,六码头,金乡广场,禹城街,临清路,东阿街,吴淞路,大港沿,辽宁路,棣纬二大厦,大港纬一路,贮水山支街,无棣纬一广场,大港纬三街,大港纬五路,大港纬四街,大港纬二路,无棣二大厦,吉林支路,大港四街,普集支路,无棣三街,黄台支广场,大港三街,无棣一路,贮水山大厦,泰山支路,大港一广场,无棣四路,大连支街,大港二路,锦州支街,德平广场,高苑大厦,长山路,乐陵街,临邑路,嫩江广场,合江路,大连街,博兴路,蒲台大厦,黄台广场,城阳街,临淄路,安邱街,临朐路,青城广场,商河路,热河大厦,济阳路,承德街,淄川广场,辽北街,阳信路,益都街,松江路,流亭大厦,吉林路,恒台街,包头路,无棣街,铁山广场,锦州街,桓台路,兴安大厦,邹平路,胶东广场,章丘路,丹东街,华阳路,青海街,泰山广场,周村大厦,四平路,台东西七街,台东东二路,台东东七广场,台东西二路,东五街,云门二路,芙蓉山村,延安二广场,云门一街,台东四路,台东一街,台东二路,杭州支广场,内蒙古路,台东七大厦,台东六路,广饶支街,台东八广场,台东三街,四平支路,郭口东街,青海支路,沈阳支大厦,菜市二路,菜市一街,北仲三路,瑞云街,滨县广场,庆祥街,万寿路,大成大厦,芙蓉路,历城广场,大名路,昌平街,平定路,长兴街,浦口广场,诸城大厦,和兴路,德盛街,宁海路,威海广场,东山路,清和街,姜沟路,雒口大厦,松山广场,长春街,昆明路,顺兴街,利津路,阳明广场,人和路,郭口大厦,营口路,昌邑街,孟庄广场,丰盛街,埕口路,丹阳街,汉口路,洮南大厦,桑梓路,沾化街,山口路,沈阳街,南口广场,振兴街,通化路,福寺大厦,峄县路,寿光广场,曹县路,昌乐街,道口路,南九水街,台湛广场,东光大厦,驼峰路,太平山,标山路,云溪广场,太清路"
			.split(",");

	public static String base = "abcdefghijklmnopqrstuvwxyz0123456789";
	private static String firstName = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
	private static String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
	private static String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
	private static final String[] email_suffix = "@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn"
			.split(",");
	private static String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153"
			.split(",");
	private static final int DISPLAYABLE_MIN_INDEX = 33;
	private static final int DISPLAYABLE_MAX_INDEX = 127 - 1;
	private static final ThreadLocal<Random> local = new ThreadLocal<Random>() {
		@Override
		protected Random initialValue() {
			return new Random();
		}
	};
	
	
	/**
	 * 
	 * <br>Description:TODO  获取随机数
	 * <br>Date:2019年12月13日
	 * @param start  开始数值
	 * @param end  结束数据
	 * @return
	 */

	public static int getNum(int start, int end) {
		return (int) (Math.random() * (end - start + 1) + start);
	}
	
	
	/**
	 * 
	 * <br>
	 * Description:TODO 获得随机数的方法 <br>
	 * Date:2019年12月13日
	 * 
	 * @param length
	 * @return
	 */
	private static int getRandom(int length) {
		Random random = new Random();
		return random.nextInt(length);
	}
	
	
	
	/**
	 * 返回手机号码
	 */

	private static String getTel() {
		int index = getNum(0, telFirst.length - 1);
		String first = telFirst[index];
		String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
		String thrid = String.valueOf(getNum(1, 9100) + 10000).substring(1);
		return first + second + thrid;
	}
	
	
	/**
	 * 数据封装
	 * getChineseName() 随机产生中文姓名 
	   getDatailedAddress（）	   返回地址
	   getTel 返回手机号码
	   getEmail 返回Email
	 * @return
	 */
	public static Map<String,Object> getAddressAndPersonMap() {
		Map<String,Object> map = new HashMap<>();
		map.put("name", getChineseName());
		map.put("sex", name_sex);
		map.put("addr", getDatailedAddress());
		map.put("tel", getTel());
		map.put("email", getEmail(6, 9));
		return map;
	}
	

	/**
	 * 返回Email
	 * 
	 * @param lMin
	 *            最小长度
	 * @param lMax
	 *            最大长度
	 * @return
	 */
	public static String getEmail(int lMin, int lMax) {
		int length = getNum(lMin, lMax);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = (int) (Math.random() * base.length());
			sb.append(base.charAt(number));
		}
		sb.append(email_suffix[(int) (Math.random() * email_suffix.length)]);
		return sb.toString();
	}

	/**
	 * 获取注定数量的随机中文字符串
	 * 
	 * @return
	 */
	public static String getChineseByNum(int num) {
		StringBuilder str = new StringBuilder();
		int hs = 0;
		int ls = 0;
		Random random = new Random();
		for (int i = 1; i <= num; i++) {
			hs = (176 + Math.abs(random.nextInt(39)));
			ls = (161 + Math.abs(random.nextInt(93)));
			byte[] b = new byte[2];
			b[0] = (new Integer(hs).byteValue());
			b[1] = (new Integer(ls).byteValue());
			try {
				str.append(new String(b, "GBK"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return str.toString();
	}
	
	/**
	 * 返回中文姓名
	 */
	private static String name_sex = "";
	private static String getChineseName() {
		int index = getNum(0, firstName.length() - 1);
		String first = firstName.substring(index, index + 1);
		int sex = getNum(0, 1);
		String str = boy;
		int length = boy.length();
		if (sex == 0) {
			str = girl;
			length = girl.length();
			name_sex = "女";
		} else {
			name_sex = "男";
		}
		index = getNum(0, length - 1);
		String second = str.substring(index, index + 1);
		int hasThird = getNum(0, 1);
		String third = "";
		if (hasThird == 1) {
			index = getNum(0, length - 1);
			third = str.substring(index, index + 1);
		}
		return first + second + third;
	}
	

	/**
	 * 返回地址
	 * 
	 * @return
	 */
	private static String getDatailedAddress() {
		String[] strings = place[getRandom(place.length)];
		
		String string2 = strings[0];
		String string3 = strings[getRandom(strings.length)];


		int index = getNum(0, road.length - 1);
		String first = road[index];
		String second = String.valueOf(getNum(11, 150)) + "号";
		String third = "-" + getNum(1, 20) + "-" + getNum(1, 10);
		return string2 + string3 + first + second + third;
	}

	/**
	 * 随机生成任意长度的数字
	 * @param num
	 * @return
	 */
	public static long getRandomByNumber(int num) {
		double random = Math.random();
		for (int i = 0; i < num; i++) {
			count *= 10;
		}
		return (long)(random*count);
	}
	
	/**
	 * 
	 * @param startNumber 企业码前缀
	 * @param k产生 k位随机整数字符串  产生位数
	 * @return
	 */
	public static String getCompanyCode(String startNumber,int k) {
	StringBuffer buffer=new StringBuffer();
	int num[] = new int[k];
	for (int i = 0; i <num.length; i++) {
		num[i] = (int) (10 * (Math.random()));
		buffer.append(num[i]);
	}
	return startNumber + buffer.toString();
	}

	/**
	 * 获取n位随机英文字符串  纯英文
	 * 
	 * @param length
	 * @return
	 */
	public static String getStringEnglishByLength(int length) {
		Random random = new Random();
		StringBuffer result = new StringBuffer();
		char[] words = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
				'Y', 'Z'};
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(26);
			String word = words[index] + "";
			int bigorsmall = random.nextInt();
			if (bigorsmall % 2 == 0) {
				word = word.toLowerCase();
			}
			result.append(word);
		}

		return result.toString();
	}
	/**
	 * 获取n位随机英文和数字字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String getStringAndNumber(int length) {
		Random random = new Random();
		StringBuffer result = new StringBuffer();
		char[] words = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
				'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(36);
			String word = words[index] + "";
			if (!StringUtil.isNumber(word)) {
				int bigorsmall = random.nextInt();
				if (bigorsmall % 2 == 0) {
					word = word.toLowerCase();
				}
			}
			result.append(word);
		}

		return result.toString();
	}
	
	/**
	 * 
	 * @param startName:公司名称前缀
	 * @param min:汉字数量最小值
	 * @param max:汉字数量最大值
	 * @param endNames:存放公司类型数组
	 * @return
	 */
	    public static String getCompanyName(String startName,int min,int max,String endNames[]) {
			String centerName=RandomUtil.randomChineseString(min, max);
			Random random=new Random();
			int index=random.nextInt(endNames.length); //0<=index<3
			String endName=endNames[index];
			String name=startName+centerName+endName;
			return name;
	    }
	    
	    //获得单个汉字
	    public String getChinese(){
	        String chinese = "";
	        int i = (int)(Math.random()*40 + 16);
	        int j = (int)(Math.random()*94 + 1);
	        if(i == 55){
	            j = (int)(Math.random()*89 + 1);
	        }
	        byte[] bytes = {(byte) (i+160),(byte) (j+160)};
	        try {
	            chinese =  new String(bytes, "gb2312");
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	        return chinese;
	    }
	 
	    /**
	     * 产生给定范围个数的汉字
	     * @param min 最小汉字数
	     * @param max 最大汉字数
	     * @return
	     */
	    public static String randomChineseString(int min,int max){
	    
	    	Random rand = new Random();
	    	int count=rand.nextInt(max-min+1) + min;
	    	
	        String name = "";
	        int chineseNameNum =  count;
	        for(int i=1; i<=chineseNameNum;i++){
	            name += new RandomUtil().getChinese();
	        }
	        return name;
	    }
	
	

	/**
	 * 获取Random实例
	 * 
	 * @return
	 */
	public static Random getRandom() {
		return local.get();
	}

	/**
	 * 产生[0, x]区间的随机数
	 * 
	 * @param x
	 *            > 0
	 * @return
	 */
	public static int intSeed(int x) {
		return intSeed(0, x);
	}

	/**
	 * 产生[x, y]区间的随机数
	 * 
	 * @param x
	 *            >= 0
	 * @param y
	 *            > x
	 * @return
	 */
	public static int intSeed(int x, int y) {
		if (x < 0) { // ensure x >= 0
			throw new IllegalArgumentException(
					"x must be greater than or equal 0");
		}
		if (x >= y) { // ensure y > x
			throw new IllegalArgumentException("y must be greater than x");
		}
		return x + getRandom().nextInt(y - x + 1);
	}

	/**
	 * 产生[0, x]区间的随机数
	 * 
	 * @param x
	 *            > 0
	 * @return
	 */
	public static long longSeed(long x) {
		return longSeed(0, x);
	}

	/**
	 * 产生[x, y]区间的随机数
	 * 
	 * @param x
	 *            >= 0
	 * @param y
	 *            > x
	 * @return
	 */
	public static long longSeed(long x, long y) {
		if (x < 0) { // ensure x >= 0
			throw new IllegalArgumentException(
					"x must be greater than or equal 0");
		}
		if (x >= y) { // ensure y > x
			throw new IllegalArgumentException("y must be greater than x");
		}
		return Math.abs(getRandom().nextLong() % (y - x + 1)) + x;
	}

	/**
	 * 产生[0, x]区间的随机小数
	 * 
	 * @param x
	 *            > 0
	 * @return
	 */
	public static float floatSeed(float x) {
		return (float) doubleSeed(0., x);
	}

	/**
	 * 产生[x, y]区间的随机小数
	 * 
	 * @param x
	 *            >= 0
	 * @param y
	 *            > x
	 * @return
	 */
	public static float floatSeed(float x, float y) {
		return (float) doubleSeed(x, y);
	}

	/**
	 * 产生[0, x]区间的随机小数
	 * 
	 * @param x
	 *            > 0
	 * @return
	 */
	public static double doubleSeed(double x) {
		return doubleSeed(0., x);
	}

	/**
	 * 产生[x, y]区间的随机小数
	 * 
	 * @param x
	 *            >= 0
	 * @param y
	 *            > x
	 * @return
	 */
	public static double doubleSeed(double x, double y) {
		if (x < 0) { // ensure x >= 0
			throw new IllegalArgumentException(
					"x must be greater than or equal 0");
		}
		if (x >= y) { // ensure y > x
			throw new IllegalArgumentException("y must be greater than x");
		}
		BigDecimal dx = new BigDecimal(String.valueOf(x));
		BigDecimal dy = new BigDecimal(String.valueOf(y));
		double diff = dy.subtract(dx).doubleValue();
		dx = dx.add(new BigDecimal(
				String.valueOf(getRandom().nextDouble() * diff)));
		return dx.doubleValue();
	}

	/**
	 * 随机产生true或false
	 * 
	 * @return
	 */
	public static boolean boolSeed() {
		return intSeed(0, 1) == 0 ? false : true;
	}
	
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		Map<String, Object> address = RandomUtil.getAddressAndPersonMap();
		System.out.println(address);
	}

}