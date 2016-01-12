package nankai.globaldata;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import mutl.touch.sample.R;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.WindowManager;

public class GlobalData {
	
	/**
	 * 一共需要多个键值对，用来存储和 显示信息
	 */
	public static final String INFO="yourindex";
	
	
	/**
	 * 添加一种花的步骤：
	 * 1.一张以花的名字（拼音）+SMALL的缩略图jpg格式，放到assets文件夹中
	 * 2.一张以花的名字（拼音）+BIG的大图jpg格式，放到assets文件夹中
	 * 3.添加public static final String 花的汉语拼音Chinese="中文名";
     *       public static final String 花的汉语拼音English="花的汉语拼音";
     *       public static final String 花的汉语拼音Introduce="花的中文介绍";
     * 4.在initparams()函数中添加映射类似于这种形式
     * hashMapPlantChinesetoEnglish.put(花的汉语拼音Chinese, 花的汉语拼音English);
	 * hashMapPlantIntroduce.put(花的汉语拼音English, 花的汉语拼音Introduce);
	 * 5.添加选择菜单，就是在 globalContent=new String[] {GlobalData.jinYeNvZhenChinese,·······};
	 * 的{}中添加GlobalData.花的汉语拼音Chinese
	 */
	
	/**
	 * 软件的使用说明
	 * 1.第一次运行本软件时，进入设置模式，可以根据地图，单击地图的某一点，放置植物说明的缩略图
	 * 放置完成后，点击返回键，自动保存到手机，以后运行时，就可直接查看植物地图
	 * 2.第二次以后运行本程序，可以直接单击地图上的相应缩略图进入植物说明
	 * 
	 * 3.注意，本程序采用智能跟随技术，地图的图片可以任意更换，只要按照步骤1重新设置好，就能供以后使用
	 * 
	 */
	
 
 
 
//金叶女贞
 public static final String jinYeNvZhenChinese="金叶女贞";
 public static final String jinYeNvZhenEnglish="jinyenvzhen";
 public static final String jinYeNvZhenIntroduce="金叶女贞\nLigustrum  vicaryi Hort（Hybrida Vicary Privet）\n落叶灌木，是金边卵叶女贞和欧洲女贞的杂交种。叶片较大叶女贞稍小，单叶对生，椭圆形或卵状椭圆形，长2～5厘米。总状花序，小花白色。核果阔椭圆形，紫黑色。金叶女贞叶色金黄，尤其在春秋两季色泽更加璀璨亮丽。\n分布：校园路边草坪里皆可见其身影，有的是球状，有的是条状。";
 //毛白杨
 public static final String maoBaiYangChinese="毛白杨";
 public static final String maoBaiYangEnglish="maobaiyang";
 public static final String maoBaiYangIntroduce="毛白杨（Populus tomentosa杨柳科杨属高大乔木，树干通直挺拔。树冠圆锥形，长枝叶卵形，基部心形，叶片下有绒毛。花期3月，果期4-5月。树皮上有富有艺术感的菱形裂纹。分布：大中路两侧尤多我感到那云状的种子在我心底强烈地碰撞上什么东西。我不能不被生命豪华的、奢侈的、不计成本的投资所感动。也许，在不分昼夜的飘散之余，只有一颗种子足以成荫，但造物主乐于做这样惊心动魄的壮举。 （张晓风《敬畏生命》） ";
 
//白车轴草
public static final String baiCheZhouCaoChinese="白车轴草";
public static final String baiCheZhouCaoEnglish="baichezhoucao";
public static final String baiCheZhouCaoIntroduce="白车轴草（Trifolium repens） 短期多年生草本，掌状三出复叶；花冠白色、乳黄色或淡红色，具香气。种子通常3粒。花果期5-10月。\n分布\n南开园各处均有分布。\n植物趣语\n又名白三叶、白花三叶草、白三草、车轴草、荷兰翘摇等。白车轴草富含多种营养物质和矿物质元素，具有很高的饲用、绿化、遗传育种和药用价值，可作为绿肥、堤岸防护草种、草坪装饰，以及蜜源和药材等用。";


//斑地锦
public static final String banDiJinChinese="斑地锦";
public static final String banDiJinEnglish="bandijin";
public static final String banDiJinIntroduce="基本信息\n斑地锦（Euphorbia maculata）一年生匍匐小草本，含白色乳汁。叶通常对生，中央有紫斑；种子卵形而有角棱，花期3-5月，果期6-9月。\n分布\n南开园各处均有分布。\n植物趣语\n斑地锦具有药用价值。具有止血，清湿热，通乳功效。主治黄疸，泄泻，疳积，血痢，尿血，血崩，外伤出血，乳汁不多，痈肿疮毒。";

//萹蓄
public static final String bianXuChinese="萹蓄";
public static final String bianXuEnglish="bianxu";
public static final String bianXuIntroduce="基本信息\n萹蓄（Polygonum aviculare）一年生草本。花单生或数朵簇生于叶腋，遍布于植株；初夏于节间开淡红色或白色小花，入秋结子，嫩叶可入药。花期5-7月，果期6-8月。\n分布\n不均匀分布在南开园各处。\n植物趣语\n对气候的适应性强，寒冷山区或温暖平坝都能生长。";

//草芙蓉
public static final String caoFuRongChinese="草芙蓉";
public static final String caoFuRongEnglish="caofurong";
public static final String caoFuRongIntroduce="基本信息\n芙蓉葵（Hibiscus moscheutos）落叶灌木状。叶大、广卵形，叶柄、叶背密生灰色星状毛。花大，单生于叶腋，有白、粉、红、紫等色。花期6-8月。\n植物趣语\n芙蓉葵的花语：早熟。早上花的颜色是白色或粉红色，一到了午后就会便成大红色。在短短的时间内能有如此变化的花，相当的特殊。";

//点地梅
public static final String dianDiMeiChinese="点地梅";
public static final String dianDiMeiEnglish="diandimei";
public static final String dianDiMeiIntroduce="基本信息\n点地梅（Androsace umbellata）一年生或二年生草本，花冠白色，花期2-4月；果期5-6月。\n分布\n不均匀分布在南开园各处。\n植物趣语\n民间用全草治扁桃腺炎、咽喉炎、口腔炎和跌打损伤。点地梅虽小，但是，不论是在高山草原，还是在河谷滩地，只要有一丁点瘠薄的土壤它就能生根发芽。它的种子能自播繁殖。也可在冰天雪地中生存";

//二乔玉兰
public static final String erQiaoYuLanChinese="二乔玉兰";
public static final String erQiaoYuLanEnglish="erqiaoyulan";
public static final String erQiaoYuLanIntroduce="基本信息\n二乔玉兰（Magnolia soulangeana ）落叶小乔木。花先叶开放；是由紫玉兰和玉兰自然杂交得到，花色比紫玉兰要淡，介于两亲本之间，外面粉红色或淡紫色，里面白色，花期3~4月；果熟期9~10月。\n分布：\n专家楼前及行政楼东侧植物带\n植物趣\n树皮，叶、花均可提取芳香浸膏。二乔玉兰是城市绿化的花木。是著名的庭园观赏品种。";

//合欢
public static final String heHuanChinese="合欢";
public static final String heHuanEnglish="hehuan";
public static final String heHuanIntroduce="基本信息\n合欢（Albizia julibrissin）落叶乔木，夏季开花，淡红色花期6-7月；果期8-10月。 \n分布：\n化学楼前小引河边；行政楼东侧停车场旁边\n植物趣语\n威海市市树。因昼开夜合故名“夜合”。合欢花在我国是吉祥之花，认为“合欢蠲（音juān，免除）忿（消怨合好）”，自古以来人们就有在宅第园池旁栽种合欢树的习俗，寓意夫妻和睦，家人团结，对邻居心平气和，友好相处。";

//红车轴草
public static final String hongCheZhouCaoChinese="红车轴草";
public static final String hongCheZhouCaoEnglish="hongchezhoucao";
public static final String hongCheZhouCaoIntroduce="基本信息\n红车轴草（Trifolium pratense）短期多年生草本，生长期2-5（-9） 年。三片叶子；花冠紫红色至淡红色。荚果卵形；通常有1粒扁圆形种子。\n分布\n南开园各处均有分布。\n植物趣语\n又名红三叶、红花苜蓿和三叶草等。具有药用、饲用、观赏等多种价值。";

//荆条
public static final String jingTiaoChinese="荆条";
public static final String jingTiaoEnglish="jingtiao";
public static final String jingTiaoIntroduce="基本信息\n荆条（Vitex negundo var. Heterophylla）落叶灌木。花淡紫色，着生于当年生枝端，花期6~7月。\n植物趣语\n“负荆请罪”,“荆钗布裙”荆枝作钗，粗布为裙。形容妇女装束朴素。";


//凌霄
public static final String lingXiaoChinese="凌霄";
public static final String lingXiaoEnglish="lingxiao";
public static final String lingXiaoIntroduce="基本信息\n凌霄 （Campsis grandiflora）落叶攀援藤本，茎木质，以气生根攀附于它物之上。花冠内面鲜红色，外面橙黄色。雄蕊着生于花冠筒近基部，。花药黄色，个字形着生。花期5-8月。\n分布：物理学院外墙；南开小花园\n植物趣语\n花语：“声誉”。凌霄花是连云港市名花之一。千年古凤凰城——南城镇，素享“凌霄之乡”美誉。凌霄花寓意慈母之爱，经常与冬青、樱草放在一起，结成花束赠送给母亲，表达对母亲的热爱之情。“我如果爱你-- 绝不像攀援的凌霄花， 借你的高枝炫耀自己”——舒婷《致橡树》";

//芦苇
public static final String luWeiChinese="芦苇";
public static final String luWeiEnglish="luwei";
public static final String luWeiIntroduce="基本信息\n芦苇（Phragmites australis）多年生高大直立草本，禾本科。植株高大，地下有发达的匍匐根状茎。叶片长线形或长披针形。夏秋开花，圆锥花序大型，顶生，疏散，多成白色。\n植物趣语\n点燃的芦苇棒会有烟，可驱蚊，无毒。\n咏芦苇（余亚飞）\n浅水之中潮湿地，婀娜芦苇一丛丛；\n迎风摇曳多姿态，质朴无华野趣浓。";

//商陆
public static final String shangLuChinese="商陆";
public static final String shangLuEnglish="shanglu";
public static final String shangLuIntroduce="基本信息\n商陆（Phytolacca acinosa）多年生粗壮草本植物。夏秋开花，花白色，总状花序。浆果扁球形，紫黑色。果序直立。花期5-8月，果期6-10月。\n分布\n不均匀分布在南开园各处。\n植物趣语\n商陆具有药用价值。通二便，泻水，散结。治水肿，胀满，脚气，喉痹，痈肿，恶疮。";

//睡莲
public static final String shuiLianChinese="睡莲";
public static final String shuiLianEnglish="shuilian";
public static final String shuiLianIntroduce="基本信息\n睡莲（Nymphaea tetragona）多年生水生草本。花大形、美丽，浮在或高出水面；花瓣白色、蓝色、黄色或粉红色。\n分布：二主楼前小河内\n植物趣语\n花语：洁净、纯真、妖艳。生于池沼中。根状茎食用或酿酒，又入药，能治小儿慢惊风；全草可作绿肥。";

//酸模
public static final String suanMoChinese="酸模";
public static final String suanMoEnglish="suanmo";
public static final String suanMoIntroduce="基本信息\n酸模（Rumex acetosa ）多年生草本。根为须根。花期5-7月，果期6-8月。\n分布\\n不均匀分布在南开园各处。/\n植物趣语 \\n花语：体贴 \\n酸模的古名为Rumex，是“吸吮”的意思。古时候人们˙在旅途中就以吸吮它的叶子来解渴。因此酸模的花语是“体贴”。受到这种花祝福而生的人，如果是女性，一定充满母爱，温柔又善解人意，就像圣母玛利亚一般。当然，一旦恋爱也是无悔的付出，让对方感受到浓浓的情意。";

//天蓝苜蓿
public static final String tianLanMuXiuChinese="天蓝苜蓿";
public static final String tianLanMuXiuEnglish="tianlanmuxiu";
public static final String tianLanMuXiuIntroduce="基本信息\n天蓝苜蓿（Medicago lupulina）一年生草本，茎高20-60厘米，叶具3小叶；小叶宽倒卵形至稜形，花10-15朵密集成头状花序；花冠黄色，荚果弯呈肾形，成熟时黑色，具纵纹，无刺，有种子1粒；种子黄褐色。\n分布\n不均匀分布在南开园各处。\n植物趣语\n是草地改良补播较理想的草种，可与中上繁性牧草混播建植永久性草地。它可以作为人工草地的主要组分，既能固氮，又可给禾草提供良好的生长条件，还可增加草地的豆科牧草成分，天蓝苜蓿还可作为草甸草原草地的改良补播草种。";

//问荆
public static final String wenJingChinese="问荆";
public static final String wenJingEnglish="wenjing";
public static final String wenJingIntroduce="基本信息\n问荆（Equisetum arvense）中小型植物。根状茎横生地下，黑褐色。地上气生的直立茎由根状茎上生出，细长，有节和节间、节间通常中空，表面有明显的纵棱。\n分布\n不均匀分布在南开园各处。\n植物趣语\n别名接续草，公母草，搂接草，空心草，马蜂草，猪鬃草，黄蚂草，节节草，接骨草。另外，具有清热、凉血、解毒、利尿等药用价值。";


//无花果
public static final String wuHuaGuoChinese="无花果";
public static final String wuHuaGuoEnglish="wuhuaguo";
public static final String wuHuaGuoIntroduce="基本信息\n无花果（Ficus carica）落叶灌木，高3-10米，多分枝，花果期5-7月。\n分布：北村居民楼前分布较多\n植物趣语\n无花果除鲜食、药用外，还可加工制干、制果脯、果酱、果汁、果茶、果酒、饮料、罐头等。无花果干无任何化学添加剂，味道浓厚、甘甜。无花果汁、饮料具有独特的清香味，生津止渴，老幼皆宜。无花果树枝繁叶茂，树态优雅，具有较好的观赏价值，是良好的园林及庭院绿化观赏树种。";

//苋
public static final String xianChinese="苋";
public static final String xianEnglish="xian";
public static final String xianIntroduce="基本信息\n苋（Amaranthus tricolor）茎粗壮，绿色或红色，常分枝，幼时有毛或无毛。叶片卵形、菱状卵形或披针形，绿色或常成红色，紫色或黄色，或部分绿色加杂其他颜色，顶端圆钝或尖凹，基部楔形，全缘或波状缘，无毛。\n分布\n不均匀分布在南开园各处。\n植物趣语\n别名：雁来红、老少年、老来少、三色苋等。有清热，利窍。治赤白痢疾，二便不通等功效。";

//香椿
public static final String xiangChunChinese="香椿";
public static final String xiangChunEnglish="xiangchun";
public static final String xiangChunIntroduce="基本信息\n香椿（Toona sinensis ）多年生落叶乔木；树皮粗糙，深褐色，有纵裂纹理。叶具长柄，偶数羽状复叶；小叶对生或互生。圆锥花序与叶等长或更长，被稀疏的锈色短柔毛或有时近无毛，小聚伞花序生于短的小枝上，多花；花长4-5毫米，具短花梗；花萼5齿裂或浅波状，外面被柔毛，且有睫毛。\n植物趣语：\n《闲情偶寄•饮馔部》中有“菜能芬人齿颊者，香椿头是也”。可见香椿之美味。香椿还有一段被称为“树王”的典故：传说古代一位皇帝作客农家，尝到了香椿嫩叶炒鸡蛋一菜，大加赞赏，于是要封香椿为“树王”，可错把“树王”的牌子挂到了臭椿树上，香椿气得连树皮都纵裂了。因此区分香椿和臭椿最明显的一条便是，香椿主干树皮纵裂，臭椿树皮不纵裂，且十分坚固。";

//香蒲
public static final String xiangPuChinese="香蒲";
public static final String xiangPuEnglish="xiangpu";
public static final String xiangPuIntroduce="基本信息\n香蒲（Typha orientalis）多年生水生或沼生草本。根状茎乳白色。地上茎粗壮，向上渐细，小坚果椭圆形至长椭圆形；果皮具长形褐色斑点。种子褐色，微弯。花果期5-8月。\n分布：河畔近水处\n植物趣语\n香蒲是制造人造棉和纸张的原料。叶和假茎分别是编织蒲包及蒲席的原料， 白嫩的假茎和根状茎可作蔬菜，蒲黄入药。";

//萱草
public static final String xuanCaoChinese="萱草";
public static final String xuanCaoEnglish="xuancao";
public static final String xuanCaoIntroduce="基本信息\n萱草（Hemerocallis fulva）多年生草本，根状茎粗短，具肉质纤维根，多数膨大呈窄长纺锤形。叶基生成丛，条状披针 形，背面被白粉。夏季开橘黄色大花。\n植物趣语\n早在康乃馨成为母爱的象征之前，我国也有一种母亲之花，它就是萱草花。又被称作“忘忧草”。来自《博物志》中：“萱草，食之令人好欢乐，忘忧思，故曰忘忧草。”";

//旋花科
public static final String xuanHuaKeChinese="旋花科";
public static final String xuanHuaKeEnglish="xuanhuake";
public static final String xuanHuaKeIntroduce="基本信息\n旋花科（Convolvulaceae）草本、亚灌木或灌木，偶为乔木，在干旱地区有些种类变成多刺的矮灌丛，或为寄生植物。约56属，1800种以上，广泛分布于热带、亚热带和温带，主产美洲和亚洲的热带、亚热带。我国有22属。\n分布\n不均匀分布在南开园各处。\n植物趣语\n代表植物：菟丝子、蕹菜、月光花、茑萝、丁公藤等。";

//鸭跖草
public static final String yaTuoCaoChinese="鸭跖草";
public static final String yaTuoCaoEnglish="yatuocao";
public static final String yaTuoCaoIntroduce="基本信息\n鸭跖草（Commelina communis）一年生披散草本。茎匍匐生根，多分枝，花朵为聚花序，顶生或腋生，雌雄同株，花瓣上面两瓣为蓝色，下面一瓣为白色。\n分布\n不均匀分布在南开园各处。\n植物趣语\n别名碧竹子、翠蝴蝶、淡竹叶、气死日头。具有药用价值以及观赏价值。";

//沿阶草
public static final String yanJieCaoChinese="沿阶草";
public static final String yanJieCaoEnglish="yanjiecao";
public static final String yanJieCaoIntroduce="基本信息\n沿阶草（Ophiopogon bodinieri）地被植物，根纤细，种子近球形或椭圆形，花期6-8月，果期 8-10月。\n分布\n不均匀分布在南开园各处。\n植物趣语\n具有药用价值和食用价值。";

//野牛草
public static final String yeNiuCaoChinese="野牛草";
public static final String yeNiuCaoEnglish="yeniucao";
public static final String yeNiuCaoIntroduce="基本信息\n野牛草（Buchloe dactyloides）多年生低矮草本植物。具匍匐茎。高不到20公分。\n分布\n不均匀分布在南开园各处。\n植物趣语\n早期的移民用以构筑住所。野牛草是重要的全年生长的饲用植物，也应用于低养护的地方，如高速公路旁、机场跑道，高尔夫球场等次级高草区。另外，还具有药用价值。";


//玉兰
public static final String yuLanChinese="玉兰";
public static final String yuLanEnglish="yulan";
public static final String yuLanIntroduce="基本信息\n玉兰（Magnolia denudata）木兰科落叶乔木，别名白玉兰、望春、玉兰花花白色到淡紫红色，大型、芳香，花冠杯状，花先开放，叶子后长，花期10天左右。树皮深灰色，粗糙开裂；小枝稍粗壮，灰褐色；冬芽及花梗密被淡灰黄色长绢毛。种子心形，侧扁。花期2-3月（亦常于7-9月再开一次花），果期8-9月。\n植物趣语\n玉兰花代表着报恩。上海市市花。另外，玉兰还具有药用价值。";

//玉簪
public static final String yuZanChinese="玉簪";
public static final String yuZanEnglish="yuzan";
public static final String yuZanIntroduce="基本信息\n玉簪 （Hosta plantaginea）多年生宿根草本花卉。顶生总状花序。花白色，筒状漏斗形，有芳香，花期7～9月。因其花苞质地娇莹如玉，状似头簪而得名。碧叶莹润，清秀挺拔，花色如玉，幽香四溢，是中国著名的传统香花，深受人们的喜爱。\n分布：北村与行政楼东侧植物带小房子前侧\n植物趣语\n花语：脱俗、冰清玉洁。宋朝诗人黄庭坚要咏之：“玉簪堕地无人拾，化作江南第一花。宴罢瑶池阿母家，嫩琼飞上紫云车。”";

//月季
public static final String yueJiChinese="月季";
public static final String yueJiEnglish="yueji";
public static final String yueJiIntroduce="基本信息\n月季（Rosa chinensis）灌木，四季开花﹐一般为红色﹐或粉色、偶有白色和黄色﹐可作为观赏植物，也可作为药用植物。\n分布：南开园内各处花坛，尤以伯苓楼旁红花月季为最盛。\n植物趣语\n月季被誉为“花中皇后”，而且有一种坚韧不屈的精神，花香悠远。中国有52个城市将他选为市花，1985年5月月季被评为中国十大名花之五。“花落花开无间断，春来春去不相关；牡丹最贵惟春晚，芍药虽繁只夏初，惟有此花开不厌，一年常占四时春”——苏东坡。";

//珍珠梅
public static final String zhenZhuMeiChinese="珍珠梅";
public static final String zhenZhuMeiEnglish="zhenzhumei";
public static final String zhenZhuMeiIntroduce="基本信息\n珍珠梅（Sorbaria sorbifolia）灌木，枝条开展；花瓣长圆形或倒卵形，白色；花期7-8月，果期9月。\n植物趣语\n花语：友情，努力。珍珠梅以其花色似珍珠而得名。珍珠梅俏丽中不失高雅，凌霜傲雪。";


//紫玉兰
public static final String ziYuLanChinese="紫玉兰";
public static final String ziYuLanEnglish="ziyulan";
public static final String ziYuLanIntroduce="基本信息\n紫玉兰 （Magnolia liliflora）落叶灌木，常丛生，树皮灰褐色，小枝绿紫色或淡褐紫色。花叶同时开放，瓶形，直立于粗壮、被毛的花梗上，稍有香气；花期3-4月，果期8-9月。\n植物趣语\n紫玉兰花朵艳丽怡人，芳香淡雅，孤植或丛植都很美观，树形婀娜，枝繁花茂，是优良的庭园、街道绿化植物，为中国有2000多年历史的传统花卉和中药。且不易移植和养护，是非常珍贵的花木。";

//白杜
public static final String baiDuChinese="白杜";
public static final String baiDuEnglish="baidu";
public static final String baiDuIntroduce="白杜(Euonymus maackii)卫矛科卫矛属落叶小乔木，单叶对生，椭圆形。雌雄异株，花期5-6月，聚伞花序，淡白绿色或黄绿色，雄蕊花药紫红色，花丝细长。分布：三食堂门前两侧各一株，新开湖东岸有较大株。植物趣语：初听“白杜”树名，便胡猜这树与李白、杜甫有关系，不知这树另有一个美丽的名字“明开夜合”，它的花小而精巧，亮红色的花药点在嫩黄的花瓣雨碧绿的花盘之上，淡雅又不失神韵，虽不关李杜，却自有风情。";

//白蜡
public static final String baiLaChinese="白蜡";
public static final String baiLaEnglish="baila";
public static final String baiLaIntroduce="基本信息:白蜡树（Fraxinus chinensis Roxb.），雌雄异株，因树上放养白蜡虫，故取名白蜡树，木犀科白蜡属植物的通称，又称梣。颇耐盐碱，与天津的土壤颇适宜，是天津市市树。分布：为良好的行道树种，主要分布励学路两侧，校园其他多处有零星分布。诗词趣语：白蜡树冠浓密而美观，可遮挡夏日的烈阳。秋季叶子黄绿参半，映着碧蓝的天空，秋味浓浓。冬季它那经冬宿存的带翅果实，在叶子落尽之时，仍然挂在枝头，随风舞动，形状颇像中国古代一种叫“磬”的乐器。";

//白皮松
public static final String baiPiSongChinese="白皮松";
public static final String baiPiSongEnglish="baipisong";
public static final String baiPiSongIntroduce="松科松属 高大乔木，树冠塔形至伞形。针叶三针一束，粗硬，雄球花卵圆形或椭圆形。花期4-5月，球果第二年10-11月成熟。分布:小花园与红磡馆西侧各有一小植株。白皮松最有意思的便是它的树皮了，幼树树皮光滑，灰绿色，长大后树皮成不规则的薄块片脱落，露出淡黄绿色的新皮，老则树皮呈淡褐灰色或灰白色，裂成不规则的鳞状块片脱落，脱落后近光滑，露出粉白色的内皮，白褐相间成斑鳞状。小花园那株还有点特殊意义呢。	";


//侧柏
public static final String ceBaiChinese="侧柏";
public static final String ceBaiEnglish="cebai";
public static final String ceBaiIntroduce="侧柏Platycladus orientalis柏科侧柏属.常绿乔木，幼树树冠卵状尖塔形，老树树冠则为广圆形。叶鳞形，交互对生。雄球花黄色，卵圆形；雌球花蓝绿色，被白粉，近球形。花期3-4月，球果10月成熟。分布：校园多处李时珍称，柏树之叶，麝食之而体香，人食之而体轻。而古时民间确有柏叶制酒之法，服用可使人耐寒暑，益五脏。比如荆楚一带风俗，流行以柏叶浸酒中，元旦阖家共饮，以祈长寿。";

//臭椿
public static final String chouChunChinese="臭椿";
public static final String chouChunEnglish="chouchun";
public static final String chouChunIntroduce="基本信息:中文学名  臭椿.拉丁学名  Ailanthus altissima (Mill.) Swingle.别称  臭椿皮、大果臭椿.二名法  Ailanthus altissima.  植物界门  被子植物门纲  双子叶植物纲亚纲  原始花被亚纲目  芸香目亚目 芸香亚目科  苦木科属  臭椿属种  臭椿.分布区域  东北南部、华北、西北至长江流域.园林用途:行道树.形态特征:落叶乔木，高可达20余米，树皮平滑而有直纹；嫩枝有髓，幼时被黄色或黄褐色柔毛，后脱落。叶为奇数羽状复叶，长40-60厘米，叶柄长7-13厘米，有小叶13-27；小叶对生或近对生，纸质，卵状披针形，长7-13厘米，宽2.5-4厘米，先端长渐尖，基部偏斜，截形或稍圆，两侧各具1或2个粗锯齿，齿背有腺体1个，叶面深绿色，背面灰绿色，柔碎后具臭味。圆锥花序长10-30厘米；花淡绿色，花梗长1-2.5毫米；萼片5，覆瓦状排列，裂片长0.5-1毫米；花瓣5，长2-2.5毫米，基部两侧被硬粗毛；雄蕊10，花丝基部密被硬粗毛，雄花中的花丝长于花瓣，雌花中的花丝短于花瓣；花药长圆形，长约1毫米；心皮5，花柱粘合，柱头5裂。翅果长椭圆形，长3-4.5厘米，宽1-1.2厘米；种子位于翅的中间，扁圆形。花期4-5月，果期8-10月。分布:分布于中国北部、东部及西南部，东南至台湾省。中国除黑龙江、吉林、新疆、青海、宁夏、甘肃和海南外，各地均有分布。向北直到辽宁南部，共跨22个省区，以黄河流域为分布中心。世界各地广为栽培。";

//刺槐
public static final String ciHuaiChinese="刺槐";
public static final String ciHuaiEnglish="cihuai";
public static final String ciHuaiIntroduce="刺槐Robinia pseudoacacia.豆科刺槐属.落叶乔木，羽状复叶，常对生，椭圆形。总状花序腋生，花冠白色，有瓣柄。花期4-6月，果期8-9月。分布：校园多处，尤以纪念碑与文科创新楼前植株高大。白居易的诗中多次出现槐花，现举两例：【秋凉闲卧】(白居易)残暑昼犹长，早凉秋尚嫩。露荷散清香，风竹含疏韵。幽闲竟日卧，衰病无人问。薄暮宅门前，槐花深一寸。【闻新蝉赠刘二十八】(白居易)蝉发一声时，槐花带两枝。只应催我老，兼遣报君知。白发生头速，青云入手迟。无过一杯酒，相劝数开眉。";

//鹅掌楸
public static final String eZhangQiuChinese="鹅掌楸";
public static final String eZhangQiuEnglish="ezhangqiu";
public static final String eZhangQiuIntroduce="基本信息:鹅掌楸(Liriodendron chinensis)木兰科鹅掌楸属.落叶乔木，树形优美、健壮。单叶互生，鹅掌形。花期5-6月，雌蕊群超花被之上，花被外面绿色，内面黄色。分布：行政楼东侧行道侧有一株.植物趣语：鹅掌楸，别称马褂木、双飘树，看来这种树是根据树叶的形状命名的，它的叶子很像T恤，随风飘动，甚是可爱。鹅掌楸还是国家二级保护植物，是一种非常珍贵的盆景观赏植物，十分稀少。";

//构树
public static final String gouShuChinese="构树";
public static final String gouShuEnglish="goushu";
public static final String gouShuIntroduce="构树Broussonetia papyrifera桑科构属.落叶乔木，雌雄异株，单叶互生，旋螺状排列。花期5-6月，雄花为葇荑花序，雌花序球形头状。聚花果成熟时橙红色，可食用，果期6-7月。分布：附中临励学路有一雌植株，行政楼东侧花园多大型雄植株。构树又称假杨梅，沙纸树。被称为“假杨梅”是因为它浆果形似杨梅果，称为“沙纸树”是因为它树皮可造纸。此外，构树的果实还可入药。尽管构树用处如此之多，但却因其易烂芯而难成才，真是白白长得高大，却做不成栋梁。";

//国槐
public static final String guoHuaiChinese="国槐";
public static final String guoHuaiEnglish="guohuai";
public static final String guoHuaiIntroduce="国槐（Sophora japonica）豆科槐属.落叶乔木，羽状复叶，圆锥花序顶生，花冠白色或淡黄色，花味芬芳，花期7月，果期8月。分布：小引河以东宿舍与老图周边多有分布.槐树被视为古代三公宰辅的象征，被视为科第吉兆的象征，故与古代读书人有千丝万缕的联系。此外，槐树还具有是古代迁民怀祖的寄托、吉祥和祥瑞的象征等文化意义。";

//旱柳
public static final String hanLiuChinese="旱柳";
public static final String hanLiuEnglish="hanliu";
public static final String hanLiuIntroduce="基本信息:旱柳（Salix matsudana）杨柳科柳属.落叶乔木，大枝斜上，树冠广圆形，耐寒冷干旱，单叶互生，披针形。雌雄异株，花期4月， 葇荑花序。分布：较分散，二主与老图多有植株较大的老树。如果说垂柳的树枝像披散的直发，婀娜多姿；那旱柳就像极了爆炸头，刚硬粗犷。因此，旱柳能生长在干旱寒冷的野外，垂柳则多见于河溪边，水土养育了它们各自的性情。";

//胡桃
public static final String huTaoChinese="胡桃";
public static final String huTaoEnglish="hutao";
public static final String huTaoIntroduce="基本信息:胡桃Juglans regia，即核桃，落叶乔木，雌雄同株。奇数羽状复叶互生，树冠广阔，花期4-5月，雌花为穗状花序，雄花柔荑花序下垂。分布：西区公寓学生宿舍楼下栽培较多，其他处有零星一两株分布。植物趣语：红罗袖里分明见，白玉盘中看却无。疑是老僧休念诵，腕前推下水晶珠。---李白《白胡桃》    一个“胡”字说明产地在西域，和李白一样的故乡，且看这首《白胡桃》，真佩服李白的顽皮与想象力啊！";

//黄栌
public static final String huangLuChinese="黄栌";
public static final String huangLuEnglish="huanglu";
public static final String huangLuIntroduce="黄栌(Cotinus coggygria) 漆树科黄栌属 落叶灌木或乔木，树冠圆形。单叶互生，倒卵形，叶柄细。花期5-6月，圆锥花序顶生。分布：新图北侧草坪边缘有4-5株.植物趣语：黄栌又称烟树，是因为它的花花丝细软浓密，像雏鸟的羽毛，花开季节，远远地看上去整棵树像是笼罩着一层薄纱。黄栌的叶子秋季转红，和路边的悬铃木一起涂抹着秋色。";

//火炬树
public static final String huoJuShuChinese="火炬树";
public static final String huoJuShuEnglish="huojushu";
public static final String huoJuShuIntroduce="火炬树(Rhus Typhina Nutt),漆树科，落叶小乔木。奇数羽状复叶，长椭圆状至披针形。花期6-7月，圆锥花序顶生，花淡绿色。核果深红，密生绒毛。分布：集中分布于学活斜坡前小树林.植物趣语：火炬树作为外来树种，具有超强的繁殖能力，在火炬树成片生长的地方，大量物种收到排挤，因此具有入侵物种的特性。";

//金枝槐
public static final String jinZhiHuaiChinese="金枝槐";
public static final String jinZhiHuaiEnglish="jinzhihuai";
public static final String jinZhiHuaiIntroduce="金枝槐(Aureus locustae) 豆科槐属 落叶乔木，树形自然张开，二年生的树茎、枝为金黄色，树皮光滑；叶互生， 羽状复叶，叶椭圆形。分布：多成片分布，红磡馆西侧，南开出版社东侧道路两边有大片分布。金枝槐的叶子颜色近现在的流行色---亮黄色，颇抢眼球，此外，难能可贵的是，金枝槐还耐干旱，耐瘠薄，是道路、风景区等园林绿化的珍品。";

//龙桑
public static final String longSangChinese="龙桑";
public static final String longSangEnglish="longsang";
public static final String longSangIntroduce="龙桑(Morus alba) 桑科桑属 落叶乔木，枝条均呈龙游状扭曲。叶心形或卵圆形，有光泽。雌雄异株，葇荑花序，花期5月。聚花果5-6月成熟，俗称桑葚。分布：新图南侧花坛内有一大雌株，另有小植株.“始虽垂翅回溪，终能奋翼渑池。可谓失之东隅，收之桑榆。”《后汉书·冯岑贾列列传第七》";

//龙爪槐
public static final String longZhuahuaiChinese="龙爪槐";
public static final String longZhuahuaiEnglish="longzhuahuai";
public static final String longZhuahuaiIntroduce="龙爪槐(Sophora japonica)豆科槐属.落叶乔木，树冠优美，羽状复叶，花期7月，果期8月，圆锥花序顶生，荚果串珠状。分布：多为行道树，校园各处多有分布。龚自珍《病梅馆记》中有：“梅以曲为美，直则无姿；以欹为美，正则无景；以疏为美，密则无态。”若真以此为标准，那龙爪槐算得上是天然的艺术品了。此外，它还是优良的蜜源植物；花和荚果入药，有清凉收敛、止血降压作用；叶和根皮有清热解毒作用，可治疗疮毒。";

//栾树
public static final String luanShuChinese="栾树";
public static final String luanShuEnglish="luanshu";
public static final String luanShuIntroduce="栾树(Koelreuteria paniculata)无患子科栾树属.落叶乔木，羽状复叶，卵形、阔卵形至卵状披针形。花期6-7月，聚散圆锥花序，密被微柔毛，花淡黄色。果期9-10月，蒴果圆锥形，三棱。分布：新阶西侧分布植株较大，学活北侧一排小植株。栾树是花、叶、果皆具观赏性的树种，尤其蒴果，形似小灯笼，颜色比树叶浅，成串成串挂在树上，远远的就能看得很清楚，果期较长，直到后来变成了绣黄色，仍不离枝干。";

//毛泡桐
public static final String maoPaoTongChinese="毛泡桐";
public static final String maoPaoTongEnglish="maopaotong";
public static final String maoPaoTongIntroduce="毛泡桐(Paulownia tomentosa)玄参科泡桐属 落叶乔木，树冠宽大伞形。单叶对生，大型卵状心形。花期5-6月，聚伞圆锥花序，花淡紫色，漏斗状钟形。分布：元素化学所楼南侧成排.植物趣语：毛泡桐的树冠宽大，却不枝繁叶茂。它的树冠形状像极了放大了的犹太烛台。半粉半紫的花朵虽不如烛光绚丽，但却能生长在干旱酷寒贫瘠之地，不失为一种坚忍，令人肃然起敬。";

//铺地柏
public static final String puDiBoChinese="铺地柏";
public static final String puDiBoEnglish="pudibo";
public static final String puDiBoIntroduce="铺地柏(Sabina procumbens)柏科圆柏属.常绿匍匐小灌木，亦作地柏，是一种矮小的柏科圆柏属灌木，原产日本。小枝密生，刺形叶。球果球形。分布：校园各处.铺地柏的匍匐枝悬垂倒挂，且常与石景搭配，古雅别致，也是制作悬崖式盆景的良好材料。";

//青扦
public static final String qingQianChinese="青扦";
public static final String qingQianEnglish="qingqian";
public static final String qingQianIntroduce="青扦Picea?wilsonii 松科云杉属 常绿乔木，树冠塔形叶排列紧密，四棱状条形，微具白粉。球果卵状圆柱形，成熟前绿色，熟时黄褐色或淡褐色。花期4月，球果10月成熟。分布：小花园与锦丘.在我看来，青扦的球果丑陋至极，却也有极复杂的构造：球果卵状圆柱形或圆柱状长卵圆形，成熟前绿色，熟时黄褐色或淡褐色；中部种鳞倒卵形，，先端圆或有急尖头，或呈钝三角形，或具突起截形之尖头，基部宽楔形，鳞背露出部分无明显的槽纹，较平滑；苞鳞匙状矩圆形，先端钝圆。";

//柿
public static final String shiChinese="柿";
public static final String shiEnglish="shi";
public static final String shiIntroduce="基本信息  柿(Diospyros kaki),又名朱果，猴枣。落叶乔木，雌雄异株。单叶互生，椭圆形。花期5-6月，黄白色花。分布：学活斜坡前成排 .植物趣语：柿树是秋天最美的树！深秋至，柿叶翻红，待西风吹落，殷红的柿子挂满枝头，像一盏盏的小纱灯，说不出的温暖与踏实。柿树也是文人墨客的爱物，“洲白芦花吐，园红柿叶稀。”（张籍《岳州晚景》），可见霜白柿叶也是萧条深秋一景。";

//水杉
public static final String shuiShanChinese="水杉";
public static final String shuiShanEnglish="shuishan";
public static final String shuiShanIntroduce="水杉(Metasequoia glyptostroboides)  杉科水杉属.水杉别称，活化石，梳子杉。高大乔木，主干挺直。枝斜展，小枝下垂。初生叶条形，交叉对生，下有气孔线。花期二月，球果11月成熟。分布  老图前，小花园。水杉是原产于我国的树种，国家首批一级保护植物，中生代白垩纪及新生代曾广泛分布北半球， 第四纪冰期后几乎绝迹，20世纪40年代中国植物学家在四川发现幸存水杉巨树 树龄400余年。";

//绦柳
public static final String tiaoLiuChinese="绦柳";
public static final String tiaoLiuEnglish="tiaoliu";
public static final String tiaoLiuIntroduce="绦柳(Salix babylonica) 杨柳科柳属 落叶乔木，雌雄异株，柳枝细长，柔软下垂。单叶互生，披针形。花期3-4月，葇荑花序。果实为蒴果，种子具绵毛。分布：马蹄湖岸边，小引河西岸.柳贵于垂，不垂则可无柳。柳条贵长，不长则无袅娜之致，徒垂无益也。此树为纳蝉之所，诸鸟亦集。长夏不寂寞，得时闻鼓吹者，而高柳为最。 李渔《闲情偶寄》";


//悬铃木
public static final String xuanLingMuChinese="悬铃木";
public static final String xuanLingMuEnglish="xuanlingmu";
public static final String xuanLingMuIntroduce="悬铃木（Platanus acerifolia）  悬铃木科悬铃木属 一球悬铃木（美国梧桐）、二球悬铃木（英国梧桐）和三球悬铃木（法国梧桐），高大乔木，雌雄异株。单叶互生，花期5月。分布：多为校园行道树，数码小院门前与范孙楼前道路两侧，马蹄湖东侧与东村各有一大型植株。形态特征  悬铃木的花单性同株，密聚成球形的头状花序，无花萼，每一个小雄花有3-8个雄蕊，雌花有3-7个雌蕊，为风媒花，授粉后雄花脱落，雌花逐渐形成只有1毫米大的小坚果组成的毛球，每个球直径约为2.5–4厘米，球散后，种子带毛，随风飞扬散播，类似蒲公英。";

//雪松
public static final String xueSongChinese="雪松";
public static final String xueSongEnglish="xuesong";
public static final String xueSongIntroduce="雪松Cedrus deodara  松科雪松属  常绿乔木，塔形树冠，主干挺直。叶针形，常成三棱，坚硬。雄球花长卵圆形，雌球花卵圆形，花期10-11月。球果成熟前淡绿色，微有白粉，熟时红褐色，卵圆形或宽椭圆形。分布：伯苓楼前花坛、小花园及东门北村附近多大植株。雪松来自喜马拉雅山脉，大雪是雪松最美的幕布，平展的树枝拖着厚厚的积雪，像一座高大的巨塔，是风雪中最美的一道风景。";

//银杏
public static final String yinXingChinese="银杏";
public static final String yinXingEnglish="yinxing";
public static final String yinXingIntroduce="银杏(Ginkgo?biloba)  银杏科银杏属 落叶乔木，主干挺拔，雌雄异株，雌株枝条较为开展，雄株枝条一般斜向上生长。叶互生，扇形，叶脉为种子植物中罕见的二叉分支。花期4-5月，果仁通称白果，可食用。分布：二主楼西侧植株较大，实习餐厅前侧小丘有成片幼株，校园另有零星分布。植物趣语:银杏，又名白果，其树为高大乔木，名公孙树，又称帝王树；叶呈扇面形，因果实形似小杏而硬皮及核肉均呈淡白色，故呼为银杏；其味甘而清香可食，起滋补药用。银杏枝雄干壮，外秀慧中，与天空相映，气势超凡。";

//油松
public static final String youSongChinese="油松";
public static final String youSongEnglish="yousong";
public static final String youSongIntroduce="油松(Pinus tabuliformis) 松科松属 常绿乔木，树枝平展或下斜展。针叶二针一束，粗硬。雌雄同株，雄球花圆柱形，花期4-5月。球果卵形或圆卵形，常宿存树上近数年之久。分布：小花园与行政楼西侧较大植株.泰山著名景观有一处叫做“五松亭”，传说当年秦始皇等泰山以行封禅大礼，突降大雨，恰巧半山腰的五棵巨大的松树亭亭如盖，为秦始皇遮挡了大雨，因护驾有功，秦始皇即封此五棵松树为“五大夫”。 ，“大夫松”这一典故，用来表达受了知遇之恩，或借此指代古松、松树。";

//榆
public static final String yuChinese="榆";
public static final String yuEnglish="yu";
public static final String yuIntroduce="榆(Ulmus pumila) 榆科榆属 高大落叶乔木，在干瘠之地为灌木状。单叶互生，长卵形或卵状披针形。花期3月，聚伞花序，花先叶开放。翅果近圆形，通称榆钱。分布：校园各处.有一个很生僻的成语为“榆瞑豆重”，语出《文选·嵇康》：“且豆令人重，榆令人瞑；合欢蠲忿，萱草忘忧，愚智所共知也。”意思是说榆钱吃多了令人昏昏沉沉，豆子吃多了让人身体沉重，用以指身懒神昏。";

//元宝槭
public static final String yuanBaoQiChinese="元宝槭";
public static final String yuanBaoQiEnglish="yuanbaoqi";
public static final String yuanBaoQiIntroduce="元宝槭(Acer truncatum)  槭树科槭树属 落叶乔木，树冠宽大。单叶对生，掌状5深裂。花期4-5月，伞房花序顶生，花小，黄绿色。分布：行政楼东侧近北村草坪上数珠分布。植物趣语：元宝槭又叫元宝枫，随着季节的深入，枫叶由绿变黄又变红，再加上形状精致，一片叶子就是一件艺术品。它的果实为“八”字形状，好像生有双翅。";

//圆柏
public static final String yuanBoChinese="圆柏";
public static final String yuanBoEnglish="yuanbo";
public static final String yuanBoIntroduce="圆柏(Sabina chinensis)柏科刺柏属.常绿乔木，尖塔形树冠，雌雄异株。叶有刺形和鳞形两种。花期4月，雄球花黄色，椭圆形，球果近圆球形。分布：校园各处.圆柏的枝叶并不漂亮，但它尖塔形的树冠站在哪里都很入镜，无半点喧闹感，直通蓝天，衬得建筑物更加肃穆庄严。";

//枣
public static final String zaoChinese="枣";
public static final String zaoEnglish="zao";
public static final String zaoIntroduce="枣(Ziziphus jujuba)鼠李科枣属.落叶乔木或灌木，树枝呈之字曲折。叶纸质，卵形或卵状椭圆形。花黄绿色，腋生聚伞花序，花期5-7月。核果长卵圆形，味甜，果期8-9月。分布：行政楼西侧有几大植株，口腔科门口与校园纪念品店门前一排小植株。在我的后园，可以看见墙外有两株树，一株是枣树，还有一株也是枣树。这上面的夜的天空，奇怪而高，我生平没有见过这样的奇怪而高的天空，他仿佛要离开人间而去，使人们仰面不再看见。然而现在却非常之蓝，闪闪地夹着几十个星星的眼，冷眼。他的口角上现出微笑，似乎自以为大有深意，而将繁霜洒在我的园里的野花草上。----鲁迅《两棵枣树》";

//梓
public static final String ziChinese="梓";
public static final String ziEnglish="zi";
public static final String ziIntroduce="梓（学名：Catalpa ovata）紫葳科梓属.伞形树冠，叶大美观；花艳丽，白色、淡黄或淡紫色。蒴果圆柱形，犹如四季豆，因此也叫“黄金条树”；种子多粒，两端各有一束白毛。《诗经·小雅·节南山之什》中有：“维桑与梓，必恭敬止。靡瞻匪父，靡依匪母。”桑树梓树为父母所栽，见桑梓易怀念父母而起恭敬之心。古人喜植桑梓于住宅周围，后人即用桑梓代称家乡。另有“梓材”做棺木，也许在古人眼中，死亡才是最终的故乡。";

//旋花
public static final String xuanHuaChinese="旋花";
public static final String xuanHuaEnglish="xuanhua";
public static final String xuanHuaIntroduce="旋花Convolvulaceae.sepium (L.) R. Br.旋花科打碗花属.分布：校园多处，无固定地点。多年生草本，全株无毛。茎缠绕，有棱，多分枝。叶柄较叶片略短，呈椭圆状箭形或戟形，侧裂片开展，略呈三角形；花生叶腋，单一；苞卵形；萼片5；花冠大，长约5cm，漏斗形，淡红色。旋花为多年生蔓草，茎细长，缠络他物之上，叶互生、戟形、有长柄，夏天开漏斗状合瓣花，色淡红，又名鼓子草。";

//飞蓬
public static final String feiPengChinese="飞蓬";
public static final String feiPengEnglish="feipeng";
public static final String feiPengIntroduce="飞蓬Erigeron speciosus (Lindl.) DC.菊科飞蓬属.叶互生、全缘或有齿缺。叶匙形或披针形，头状花序异性，放射状。边花雌性、多列、舌状；花粉红色、蓝色、白色等，盘花两性、管状、结实，与边花异色。分布：校园多处，无固定地点。原产北美，我国南北各省都有分布。对环境选择不严，极易栽培。喜向阳，性耐寒，要求土壤疏松、肥沃、湿润而排水良好，种子自播力强。华北地区可露地越冬。";

//狗尾草
public static final String gouWeiCaoChinese="狗尾草";
public static final String gouWeiCaoEnglish="gouweicao";
public static final String gouWeiCaoIntroduce="狗尾草Setaria viridis?禾本科.狗尾草属.一年生草本植物。根为须状，高大植株具支持根。秆直立或基部膝曲，高10-100厘米，基部径达3-7毫米。叶鞘松弛，无毛或疏具柔毛或疣毛，边缘具较长的密绵毛状纤毛.分布：校园多处，无固定地点。狗尾草生于荒野、道旁，为旱地作物常见的一种杂草。具有药用价值，有祛风明目，清热利尿的作用。";

//虎尾草
public static final String huWeiCaoChinese="虎尾草";
public static final String huWeiCaoEnglish="huweicao";
public static final String huWeiCaoIntroduce="虎尾草Chloris virgata Sw.禾本科虎尾草属,一年生草本。秆直立或基部膝曲光滑无毛。叶鞘背部具脊，包卷松弛，无毛；穗状花序5至10余枚，指状着生于秆顶，常直立而并拢成毛刷状，有时包藏于顶叶之膨胀叶鞘中，成熟时常带紫色。分布：校园多处，无固定地点。虎尾草适应性极强，耐干旱，喜湿润，不耐淹；喜肥沃，耐瘠薄；适生于路边、荒地、果园、苗圃也极常见。有时也形成群落，但大面积群落较少，多与其它杂草混生。";

//槐叶萍
public static final String huaiYePingChinese="槐叶萍";
public static final String huaiYePingEnglish="huaiyeping";
public static final String huaiYePingIntroduce="槐叶萍:茎细长，横走，无根，密被褐色节状短毛。叶3片轮生，二片漂浮水面，一片细裂如丝，在水中形成假根，密生有节的粗毛，水面叶在茎两侧紧密排列，形如槐叶，叶片长圆形或椭圆形。槐叶萍，因叶子形似槐树的羽状叶而得名，此外还有蜈蚣萍、山椒藻的别名，是一种漂浮在水面上的水生植物。分布：为水生杂草，全草也可供药用。生于水田，沟塘和静水溪河内。喜欢生长在温暖、无污染的静水水域上。";

//金色狗尾草
public static final String jinSeGouWeiCaoChinese="金色狗尾草";
public static final String jinSeGouWeiCaoEnglish="jinsegouweicao";
public static final String jinSeGouWeiCaoIntroduce="金色狗尾草Setaria glauca禾本科,狗尾草属.金色狗尾草，一年生；单生或丛生。秆直立或基部倾斜膝曲，近地面节可生根，光滑无毛，仅花序下面稍粗糙。叶鞘下部扁压具脊，上部圆形，光滑无毛，边缘薄膜质，光滑无纤毛。分布：校园多处，地点不固定。药用价值：全草(金色狗尾草)：淡，凉。清热明目，止泻。用于目赤肿痛，眼弦赤烂，痢疾。";

//栝楼
public static final String kuoLouChinese="栝楼";
public static final String kuoLouEnglish="kuolou";
public static final String kuoLouIntroduce="栝楼Trichosanthes kirilowii Maxim.葫芦科栝楼属.葫芦科栝楼属多年生攀缘草本。根状茎肥厚，圆柱状，外皮黄色。茎多分枝，无毛；叶互生，近圆形或心形，雌雄异株；雄花数朵总状花序，少有单生，花冠裂片倒卵形，雌花单生，子房卵形，果实近球形，熟时橙红色，花果期7～11月。分布：医学院楼后侧.栝楼有解热止渴、利尿、镇咳祛痰等作用。 种子含脂花肪油；果实含三萜皂苷、有机酸、树脂、糖类、色素；根含蛋白质、皂苷、酸类。我国大部分地区均有分布。";

//藜
public static final String liChinese="藜";
public static final String liEnglish="li";
public static final String liIntroduce="藜Chenopodium album藜科藜属.一年生草本，高30-150厘米。茎直立，粗壮，具条棱及绿色或紫红色色条，多分枝；枝条斜升或开展。叶片菱状卵形至宽披针形，先端急尖或微钝，基部楔形至宽楔形；花两性，花簇于枝上部排列成或大或小的穗状圆锥状或圆锥状花序.分布：校园多处，无固定生长地点。植物趣语：藜性味甘、平，微毒，该物种为中国植物图谱数据库收录的有毒植物。";

//马齿苋
public static final String maChiXianChinese="马齿苋";
public static final String maChiXianEnglish="machixian";
public static final String maChiXianIntroduce="马齿苋Portulaca oleracea马齿苋科，马齿苋属.一年生草本，全株无毛。茎平卧或斜倚，伏地铺散，多分枝，圆柱形，长10-15厘米淡绿色或带暗红色。茎紫红色，叶互生，有时近对生，叶片扁平，肥厚，倒卵形，似马齿状。分布：校园多处，无固定地点。生于田野路边及庭园废墟等向阳处。国内各地均有分布。该种为药食两用植物。全草供药用，有清热利湿、解毒消肿、消炎、止渴、利尿作用；种子明目。";

//马唐
public static final String maTangChinese="马唐";
public static final String maTangEnglish="matang";
public static final String maTangIntroduce="马唐Digitaria sanguinalis (L. ) Scop.禾本科马唐属.一年生杂草。秆直?立或下部倾斜，膝曲上升，无毛或节生柔毛。叶片线状披针形，基部圆形，边缘较厚，微粗糙，具柔毛或无毛。总状花序长5-18厘米，4-12枚成指状着生于长1-2厘米的主轴上；穗轴直伸或开展，两侧具宽翼，边缘粗糙。分布：校园各处，无固定地点。马唐别名众多也有趣，包括羊麻、羊粟、马饭、抓根草、鸡爪草、指草、蟋蟀草、抓地龙。";

//牛筋草
public static final String niuJingCaoChinese="牛筋草";
public static final String niuJingCaoEnglish="niujingcao";
public static final String niuJingCaoIntroduce="牛筋草Eleusine indica.禾本科穇属.一年生草本。根系极发达。秆丛生，基部倾斜。叶鞘两侧压扁而具脊，松弛，无毛或疏生疣毛。穗状花序2-7个指状着生于秆顶，很少单生。分布：随处分布，地点不固定。牛筋草，因其贴地有力不易铲锄，山东方言叫钝刀驴。以此草与金银花制剂配合常服，可以预防流感及其他流行疫病。效果大大强于板蓝根，板蓝根冲剂无论对普通感冒或流感都基本无效，只是一种心理安慰的药品。";

//蒲公英
public static final String puGongYingChinese="蒲公英";
public static final String puGongYingEnglish="pugongying";
public static final String puGongYingIntroduce="蒲公英（Taraxacum mongolicum?Hand.-Mazz.）菊科，蒲公英属.多年生草本植物。根圆锥状，表面棕褐色，皱缩，叶边缘有时具波状齿或羽状深裂，基部渐狭成叶柄，叶柄及主脉常带红紫色，花葶上部紫红色，密被蛛丝状白色长柔毛；头状花序，总苞钟状，瘦果暗褐色，长冠毛白色，花果期4～10月。分布：校园多处，敬业广场很常见。蒲公英别名黄花地丁、婆婆丁、华花郎等。菊科多年生草本植物。头状花序，种子上有白色冠毛结成的绒球，花开后随风飘到新的地方孕育新生命。";

//牵牛
public static final String qianNiuChinese="牵牛";
public static final String qianNiuEnglish="qianniu";
public static final String qianNiuIntroduce="牵牛.Pharbitis nil (Linn.)Choisy.旋花科牵牛属.分布：校园多处，地点不固定。一年生缠绕草本，茎上被倒向的短柔毛及杂有倒向或开展的长硬毛。叶宽卵形或近圆形，花腋生，单一或通常2朵着生于花序梗顶，花序梗长短不一；花冠漏斗状，长5-8（-10）厘米，蓝紫色或紫红色，花冠管色淡。这一种植物的花酷似喇叭状，因此有些地方叫它做喇叭花。种植牵牛花一般在春天播种，夏秋开花，其品种很多，花的颜色有蓝、绯红、桃红、紫等，亦有混色的，花瓣边缘的变化较多，是常见的观赏植物。果实卵球形，可以入药。";

//碎米莎草
public static final String suiMiShaCaoChinese="碎米莎草";
public static final String suiMiShaCaoEnglish="suimishacao";
public static final String suiMiShaCaoIntroduce="碎米莎草Cyperus iria.莎草科莎草属.分布：校园多处，无固定地点。一年生草本。秆丛生，扁三棱形。叶片长线形，短于秆，叶鞘红棕色。穗状花序长1～4厘米，具小穗。小坚果倒卵形或椭圆形、三棱形，褐色。花果期6～10月。碎米莎草为草本植物。有须根，秆为扁三稜形，穗多为长圆形和披针形，果实呈倒卵形或椭圆形。";

//旋复花
public static final String xuanFuHuaChinese="旋复花";
public static final String xuanFuHuaEnglish="xuanfuhua";
public static final String xuanFuHuaIntroduce="旋复花Inula japonica Thunb.菊科旋复花属.多年生草本，茎具纵棱，绿色或微带紫红色。叶互生，椭圆形、椭圆状披针形或窄长椭圆形。头状花序少数或多数，顶生，呈伞房状排列。瘦果长椭圆形，被白色硬毛，冠毛白色。花期7～10月。果期8～11月。旋复花，又名：驴儿草、百叶草。瘦果椭圆形，顶端践形，具棱，被白色疏硬毛，冠毛白色。花期6～9月。果期7～10月。生长于山坡、路旁或田边。分布东北、华北、华东等地。";

//异型莎草
public static final String yiXingShaCaoChinese="异型莎草";
public static final String yiXingShaCaoEnglish="yixingshacao";
public static final String yiXingShaCaoIntroduce="异型莎草Cyperus difformis L．莎草科莎草属.一年生草本。秆丛生，扁三棱形。叶线形，短于秆；叶鞘褐色；头状花序球形，具极多数小穗，小坚果倒卵状椭圆形、三棱形，淡黄色。花果期7～10月。分布：校园多处，地点不固定。一年生草本。花果期夏、秋季，以种子繁殖，子实极多，成熟后即脱落，春季出苗。为低洼潮湿的旱地的恶性杂草。生于稻田或水边潮湿处。";

//早开堇菜
public static final String zaoKaiJinCaiChinese="早开堇菜";
public static final String zaoKaiJinCaiEnglish="zaokaijincai";
public static final String zaoKaiJinCaiIntroduce="早开堇菜Viola prionantha.堇菜科.多年生草本，无地上茎，花期高3-10厘米，果期高可达20厘米。根状茎垂直，上端常有前一年残叶围绕。根数条，带灰白色，粗而长，通常皆由根状茎的下端发出，向下直伸，或有时近横生。叶多数，均基生；叶片在花期呈长圆状卵形、卵状披针形或狭卵形。早开堇菜几乎与蒲公英同时开花。但它们的花期很短，大概也就是2周左右。不像蒲公英从早春一直开到初夏。它的叶片和蒲公英一样称为基生叶。意思是没有地上茎，叶片全部从基部发出。";

//紫花地丁
public static final String ziHuaDiDingChinese="紫花地丁";
public static final String ziHuaDiDingEnglish="zihuadiding";
public static final String ziHuaDiDingIntroduce="紫花地丁Viola philippica.堇菜科,堇菜属.多年生草本，无地上茎，叶片下部呈三角状卵形或狭卵形，上部者较长，呈长圆形、狭卵状披针形或长圆状卵形，花中等大，紫堇色或淡紫色，稀呈白色，喉部色较淡并带有紫色条纹；蒴果长圆形种子卵球形，淡黄色。花果期4月中下旬至9月。可用作中草药，味苦、辛、寒。归心、肺经。具有清热解毒，凉血消肿，清热利湿的作用，主治疔疮，痈肿，瘰疬，黄疸，痢疾，腹泻，目赤，喉痹，毒蛇咬伤。";
























public static final String[] globalChinese=new String[] {
    GlobalData.jinYeNvZhenChinese,
    GlobalData.maoBaiYangChinese,
    GlobalData.baiCheZhouCaoChinese,
    GlobalData.bianXuChinese,
    GlobalData.caoFuRongChinese,
    GlobalData.dianDiMeiChinese,
    GlobalData.erQiaoYuLanChinese,
    GlobalData.heHuanChinese,
    GlobalData.hongCheZhouCaoChinese,
    GlobalData.jingTiaoChinese,
    GlobalData.lingXiaoChinese,
    GlobalData.luWeiChinese,
    GlobalData.shangLuChinese,
    GlobalData.shuiLianChinese,
   // GlobalData.suanMoChinese,
    GlobalData.tianLanMuXiuChinese,
   // GlobalData.wenJingChinese,
    GlobalData.wuHuaGuoChinese,
    GlobalData.xianChinese,
    GlobalData.xiangChunChinese,
    GlobalData.xiangPuChinese,
    GlobalData.xuanCaoChinese,
    //GlobalData.xuanHuaKeChinese,
    GlobalData.yaTuoCaoChinese,
    //GlobalData.yanJieCaoChinese,
    GlobalData.yeNiuCaoChinese,
    GlobalData.yuLanChinese,
    GlobalData.yuZanChinese,
    GlobalData.yueJiChinese,
    GlobalData.zhenZhuMeiChinese,
  //  GlobalData.ziYuLanChinese,
    GlobalData.baiDuChinese,
    GlobalData.baiLaChinese,
    GlobalData.baiPiSongChinese,
    GlobalData.ceBaiChinese,
    GlobalData.chouChunChinese,
    GlobalData.ciHuaiChinese,
    GlobalData.eZhangQiuChinese,
    GlobalData.gouShuChinese,
    GlobalData.guoHuaiChinese,
    GlobalData.hanLiuChinese,
    //GlobalData.huTaoChinese,//?????
    GlobalData.huangLuChinese,
    GlobalData.huoJuShuChinese,
    GlobalData.jinZhiHuaiChinese,
    GlobalData.longSangChinese,
    GlobalData.longZhuahuaiChinese,
    GlobalData.luanShuChinese,
    GlobalData.maoPaoTongChinese,
    //GlobalData.puDiBoChinese,
    GlobalData.qingQianChinese,
    GlobalData.shiChinese,
    GlobalData.shuiShanChinese,
    GlobalData.tiaoLiuChinese,
    GlobalData.xiangChunChinese,
    GlobalData.xuanLingMuChinese,
    GlobalData.xueSongChinese,
    GlobalData.yinXingChinese,
    GlobalData.youSongChinese,
    GlobalData.yuChinese,
    GlobalData.yuanBaoQiChinese,
    GlobalData.yuanBoChinese,
    GlobalData.zaoChinese,
   // GlobalData.ziChinese,
    GlobalData.xuanHuaChinese,
    GlobalData.feiPengChinese,
    GlobalData.gouWeiCaoChinese,
    GlobalData.huWeiCaoChinese,
   // GlobalData.huaiYePingChinese,
    GlobalData.jinSeGouWeiCaoChinese,
    GlobalData.kuoLouChinese,
    GlobalData.liChinese,
    GlobalData.maChiXianChinese,
    GlobalData.maTangChinese,
    GlobalData.niuJingCaoChinese,
    GlobalData.puGongYingChinese,
    GlobalData.qianNiuChinese,
    GlobalData.suiMiShaCaoChinese,
   // GlobalData.xuanFuHuaChinese,
    GlobalData.yiXingShaCaoChinese,
    GlobalData.zaoKaiJinCaiChinese,
    GlobalData.ziHuaDiDingChinese
    
    
                                                    
};

private final static String[] globalEnglish=new String[]{
	 GlobalData.jinYeNvZhenEnglish,
	 GlobalData.maoBaiYangEnglish,
	 GlobalData.baiCheZhouCaoEnglish,
	 GlobalData.bianXuEnglish,
	 GlobalData.caoFuRongEnglish,
	 GlobalData.dianDiMeiEnglish,
	 GlobalData.erQiaoYuLanEnglish,
	 GlobalData.heHuanEnglish,
	 GlobalData.hongCheZhouCaoEnglish,
	 GlobalData.jingTiaoEnglish,
	 GlobalData.lingXiaoEnglish,
	 GlobalData.luWeiEnglish,
	 GlobalData.shangLuEnglish,
	 GlobalData.shuiLianEnglish,
	// GlobalData.suanMoEnglish,
	 GlobalData.tianLanMuXiuEnglish,
	// GlobalData.wenJingEnglish,
	 GlobalData.wuHuaGuoEnglish,
	 GlobalData.xianEnglish,
	 GlobalData.xiangChunEnglish,
	 GlobalData.xiangPuEnglish,
	 GlobalData.xuanCaoEnglish,
	// GlobalData.xuanHuaKeEnglish,
	 GlobalData.yaTuoCaoEnglish,
	 // GlobalData.yanJieCaoEnglish,
	  GlobalData.yeNiuCaoEnglish,
	  GlobalData.yuLanEnglish,
	  GlobalData.yuZanEnglish,
	  GlobalData.yueJiEnglish,
	  GlobalData.zhenZhuMeiEnglish,
	 // GlobalData.ziYuLanEnglish,
	  GlobalData.baiDuEnglish,
	  GlobalData.baiLaEnglish,
	  GlobalData.baiPiSongEnglish,
	  GlobalData.ceBaiEnglish,
	 GlobalData.chouChunEnglish,
	 GlobalData.ciHuaiEnglish,
	 GlobalData.eZhangQiuEnglish,
	 GlobalData.gouShuEnglish,
	 GlobalData.guoHuaiEnglish,
	 GlobalData.hanLiuEnglish,
	// GlobalData.huTaoEnglish,
	 GlobalData.huangLuEnglish,
	 GlobalData.huoJuShuEnglish,
	 GlobalData.jinZhiHuaiEnglish,
	 GlobalData.longSangEnglish,
	 GlobalData.longZhuahuaiEnglish,
	 GlobalData.luanShuEnglish,
	 GlobalData.maoPaoTongEnglish,
	// GlobalData.puDiBoEnglish,
	 GlobalData.qingQianEnglish,
	 GlobalData.shiEnglish,
	 GlobalData.shuiShanEnglish,
	 GlobalData.tiaoLiuEnglish,
	 GlobalData.xiangChunEnglish,
	 GlobalData.xuanLingMuEnglish,
	 GlobalData.xueSongEnglish,
	 GlobalData.yinXingEnglish,
	 GlobalData.youSongEnglish,
	 GlobalData.yuEnglish,
	 GlobalData.yuanBaoQiEnglish,
	 GlobalData.yuanBoEnglish,
	 GlobalData.zaoEnglish,
	// GlobalData.ziEnglish,
	 GlobalData.xuanHuaEnglish,
	 GlobalData.feiPengEnglish,
	 GlobalData.gouWeiCaoEnglish,
	 GlobalData.huWeiCaoEnglish,
	// GlobalData.huaiYePingEnglish,
	 GlobalData.jinSeGouWeiCaoEnglish,
	 GlobalData.kuoLouEnglish,
	 GlobalData.liEnglish,
	 GlobalData.maChiXianEnglish,
	 GlobalData.maTangEnglish,
	 GlobalData.niuJingCaoEnglish,
	 GlobalData.puGongYingEnglish,
	 GlobalData.qianNiuEnglish,
	 GlobalData.suiMiShaCaoEnglish,
	// GlobalData.xuanFuHuaEnglish,
	 GlobalData.yiXingShaCaoEnglish,
	 GlobalData.zaoKaiJinCaiEnglish,
	 GlobalData.ziHuaDiDingEnglish
	 
	 
};
private static final String[] globalIntroduce=new String[]{
	 GlobalData.jinYeNvZhenIntroduce,
	 GlobalData.maoBaiYangIntroduce,
	 GlobalData.baiCheZhouCaoIntroduce,
	 GlobalData.bianXuIntroduce,
	 GlobalData.caoFuRongIntroduce,
	 GlobalData.dianDiMeiIntroduce,
	 GlobalData.erQiaoYuLanIntroduce,
	 GlobalData.heHuanIntroduce,
	 GlobalData.hongCheZhouCaoIntroduce,
	 GlobalData.jingTiaoIntroduce,
	 GlobalData.lingXiaoIntroduce,
	 GlobalData.luWeiIntroduce,
	 GlobalData.shangLuIntroduce,
	 GlobalData.shuiLianIntroduce,
	// GlobalData.suanMoIntroduce,
	 GlobalData.tianLanMuXiuIntroduce,
	// GlobalData.wenJingIntroduce,
	 GlobalData.wuHuaGuoIntroduce,
	 GlobalData.xianIntroduce,
	 GlobalData.xiangChunIntroduce,
	 GlobalData.xiangPuIntroduce,
	 GlobalData.xuanCaoIntroduce,
	// GlobalData.xuanHuaKeIntroduce,
	 GlobalData.yaTuoCaoIntroduce,
	 // GlobalData.yanJieCaoIntroduce,
	  GlobalData.yeNiuCaoIntroduce,
	  GlobalData.yuLanIntroduce,
	  GlobalData.yuZanIntroduce,
	  GlobalData.yueJiIntroduce,
	  GlobalData.zhenZhuMeiIntroduce,
	 // GlobalData.ziYuLanIntroduce,
	  GlobalData.baiDuIntroduce,
	  GlobalData.baiLaIntroduce,
	  GlobalData.baiPiSongIntroduce,
	  GlobalData.ceBaiIntroduce,
	  GlobalData.chouChunIntroduce,
	  GlobalData.ciHuaiIntroduce,
	  GlobalData.eZhangQiuIntroduce,
	  GlobalData.gouShuIntroduce,
	  GlobalData.guoHuaiIntroduce,
	  GlobalData.hanLiuIntroduce,
	// GlobalData.huTaoIntroduce,
	 GlobalData.huangLuIntroduce,
	 GlobalData.huoJuShuIntroduce,
	 GlobalData.jinZhiHuaiIntroduce,
	 GlobalData.longSangIntroduce,
	 GlobalData.longZhuahuaiIntroduce,
	 GlobalData.luanShuIntroduce,
	 GlobalData.maoPaoTongIntroduce,
	// GlobalData.puDiBoIntroduce,
	 GlobalData.qingQianIntroduce,
	 GlobalData.shiIntroduce,
	 GlobalData.shuiShanIntroduce,
	 GlobalData.tiaoLiuIntroduce,
	 GlobalData.xiangChunIntroduce,
	 GlobalData.xuanLingMuIntroduce,
	 GlobalData.xueSongIntroduce,
	 GlobalData.yinXingIntroduce,
	 GlobalData.youSongIntroduce,
	 GlobalData.yuIntroduce,
	 GlobalData.yuanBaoQiIntroduce,
	 GlobalData.yuanBoIntroduce,
	 GlobalData.zaoIntroduce,
	// GlobalData.ziIntroduce,
	 GlobalData.xuanHuaIntroduce,
	 GlobalData.feiPengIntroduce,
	 GlobalData.gouWeiCaoIntroduce,
	 GlobalData.huWeiCaoIntroduce,
	// GlobalData.huaiYePingIntroduce,
	 GlobalData.jinSeGouWeiCaoIntroduce,
	 GlobalData.kuoLouIntroduce,
	 GlobalData.liIntroduce,
	 GlobalData.maChiXianIntroduce,
	 GlobalData.maTangIntroduce,
	 GlobalData.niuJingCaoIntroduce,
	 GlobalData.puGongYingIntroduce,
	 GlobalData.qianNiuIntroduce,
	 GlobalData.suiMiShaCaoIntroduce,
	// GlobalData.xuanFuHuaIntroduce,
	 GlobalData.yiXingShaCaoIntroduce,
	 GlobalData.zaoKaiJinCaiIntroduce,
	 GlobalData.ziHuaDiDingIntroduce
	 
	 
	 
};



 
 //需要保存的数据
 public static  int globalIndex=0;//植物总数
 public static  ArrayList<PointF> arraylistPointF=new ArrayList<PointF>(500);//各个植物的坐标
 public static  Matrix globalMatrix=new Matrix();
 public static  ArrayList<String> arraylistPlantName=new ArrayList<String>(500);//植物对应的序号，和设置时对应
 
 
 //不需要保存的数据
 public static  HashMap<String, String> hashMapPlantChinesetoEnglish=new HashMap<String, String>();//中文到英文的转换
 public static  HashMap<String, String> hashMapPlantIntroduce=new HashMap<String, String>();//植物名称和说明对应
// public static  HashMap<String, Bitmap> hashMapPlantThrumbnail=new HashMap<String, Bitmap>();//植物名称对应的缩略图

 public  static Bitmap bmpThrumbnail=null;
 
//根据名称从Assets中提取图片 缩略图
public static Bitmap getSmallBitmapThrumbnail(Context context,int resId)
{

	 int width=0;
	 int height=0;
	 
	/* BitmapFactory.Options opt = new BitmapFactory.Options();  
     opt.inPreferredConfig = Bitmap.Config.RGB_565;   
     opt.inPurgeable = true;  
     opt.inInputShareable = true;  
       //获取资源图片  
     InputStream is = context.getResources().openRawResource(resId); 
     BitmapFactory.decodeStream(is,null,opt);*/
    
     
	 WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

    width = wm.getDefaultDisplay().getWidth();
    height = wm.getDefaultDisplay().getHeight();
    /**
     * 根据不同分辨率设置不同的缩略图
     */
    if(width>480)
    {
    	width=53;
    	height=70;
    }
    else
    	if(width>320 && width<=480)
    	{
    		width=26;
    		height=40; 
    	}
    	else
	    {
    		width=15;
    		height=25; 
	    }

	 Matrix matrix=new Matrix();
	 
	 try {
	    
	    Bitmap bmp =BitmapFactory.decodeResource(context.getResources(), R.drawable.tubiao)  ;//BitmapFactory.decodeStream(is,null,opt); 
	    
	    float scalex=(float)width/bmp.getWidth();
 	    float scaley=(float)height/bmp.getHeight();
 	  //在x轴和y轴上都放大fx倍，等比缩放
 	     matrix.setScale(scalex, scaley, 0, 0);
 	     Bitmap bitmap =Bitmap.createBitmap(width,height,Config.ARGB_8888); // 背景图片  
 	         Canvas canvas = new Canvas(bitmap); // 新建画布  
 	       canvas.drawBitmap(bmp, matrix, null); // 画图片  
 	       //Paint paint=new Paint();
	       //   paint.setColor(Color.RED);
	       //   paint.setStyle(Style.STROKE);//空心矩形
	       //   paint.setStrokeWidth(5);
	      //    canvas.drawRect(new Rect(0, 0, width, height), paint);
 	          
 	          
 	          canvas.save(Canvas.ALL_SAVE_FLAG); // 保存画布  
 	         canvas.restore(); 
	    
	    
	    return bitmap;

	   } catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    System.out.println("==========file not found======");
	    return null;
	   }
}

 
 public static void initparams()
 {
	 
	 for(int i=0;i<500;i++)
	 {
		 arraylistPointF.add(i, new PointF(0,0));
		 arraylistPlantName.add(i,"null");
	 }
	 //只需设置中英文转化就行了，其他的在程序中动态设置
	 //arraylistPointF.
	 for(int i=0;i<globalChinese.length;i++)
	 {
		 hashMapPlantChinesetoEnglish.put(globalChinese[i], globalEnglish[i]);
		 hashMapPlantIntroduce.put(globalEnglish[i],globalIntroduce[i]);
		 
	 }
	/* //金叶女贞
	 hashMapPlantChinesetoEnglish.put(jinYeNvZhenChinese, jinYeNvZhenEnglish);
	 hashMapPlantIntroduce.put(jinYeNvZhenEnglish, jinYeNvZhenIntroduce);
	 
	 //毛白杨
	 hashMapPlantChinesetoEnglish.put(maoBaiYangChinese, maoBaiYangEnglish);
	 hashMapPlantIntroduce.put(maoBaiYangEnglish, maoBaiYangIntroduce);
	 
	//白车轴草
	 hashMapPlantChinesetoEnglish.put(baiCheZhouChinese, baiCheZhouEnglish);
	 hashMapPlantIntroduce.put(baiCheZhouEnglish, baiCheZhouIntroduce);
	 
	//斑地锦
	 hashMapPlantChinesetoEnglish.put(banDiJinChinese, banDiJinEnglish);
	 hashMapPlantIntroduce.put(banDiJinEnglish, banDiJinIntroduce);
	 */
	 
	 
	 
	 
	 
 }
 
 public static int matrixCheckTransport(Matrix matrix1,Bitmap gintama,int widthScreen,int heightScreen)
 {
	 /**
	  * which 滑动方式
	  * 0：正常滑动
	  * 1：左上角x=0滑动判断
	  * 2：左上角y=0判断
	  * 3: 左下角x=0判断 
	  * 4: 左下角y=heighscreen判断
	  * 5678:同上
	  * 9:取消本次变换
	  */
	 int which=0;
	 float[] f = new float[9];  
     matrix1.getValues(f);  
     // 图片4个顶点的坐标  
     float x1 = f[0] * 0 + f[1] * 0 + f[2];  
     float y1 = f[3] * 0 + f[4] * 0 + f[5];  
     float x2 = f[0] * gintama.getWidth() + f[1] * 0 + f[2];  
     float y2 = f[3] * gintama.getWidth() + f[4] * 0 + f[5];  
     float x3 = f[0] * 0 + f[1] * gintama.getHeight() + f[2];  
     float y3 = f[3] * 0 + f[4] * gintama.getHeight() + f[5];  
     float x4 = f[0] * gintama.getWidth() + f[1] * gintama.getHeight() + f[2];  
     float y4 = f[3] * gintama.getWidth() + f[4] * gintama.getHeight() + f[5];  
     // 图片现宽度  
     //打印图片现在参数
     System.out.println("坐标1："+x1+":"+y1);
     System.out.println("坐标2："+x2+":"+y2);
     System.out.println("坐标3："+x3+":"+y3);
     System.out.println("坐标4："+x4+":"+y4);
     
     
     
     if(x1>0 &&y1<0 )
    	 return 1;
     if(y1>0 && x1<0)
    	 return 2;
     
	 
     
     if(x3>0 &&y3>heightScreen )
    	 return 3;
     if(y3<heightScreen && x3<0)
    	 return 4;
     
     
     if(x2<widthScreen &&y2<0 )
    	 return 5;
     if(y2>0 && x2>widthScreen)
    	 return 6;
     
     if(x4<widthScreen &&y2>heightScreen )
    	 return 7;
     if(y4<heightScreen && x4>widthScreen)
    	 return 8;
     
     if((x1>=0 || y1>=0)||(x2<=widthScreen || y2>=0)||(x3>=0 || y3<=heightScreen)||(x4<=widthScreen ||y4<=heightScreen))
    	 return 9;
     
	 return which;
 }
 /**
  * 图片的出界判断,简单的判断方法，操作性不太好
  * 判断理论是矩阵的计算
  * 参考http://blog.csdn.net/webrobot/article/details/7359626
  */
 public static boolean matrixCheck(Matrix matrix1,Bitmap gintama,int widthScreen,int heightScreen ) {  
     float[] f = new float[9];  
     matrix1.getValues(f);  
     // 图片4个顶点的坐标  
     float x1 = f[0] * 0 + f[1] * 0 + f[2];  
     float y1 = f[3] * 0 + f[4] * 0 + f[5];  
     float x2 = f[0] * gintama.getWidth() + f[1] * 0 + f[2];  
     float y2 = f[3] * gintama.getWidth() + f[4] * 0 + f[5];  
     float x3 = f[0] * 0 + f[1] * gintama.getHeight() + f[2];  
     float y3 = f[3] * 0 + f[4] * gintama.getHeight() + f[5];  
     float x4 = f[0] * gintama.getWidth() + f[1] * gintama.getHeight() + f[2];  
     float y4 = f[3] * gintama.getWidth() + f[4] * gintama.getHeight() + f[5];  
     // 图片现宽度  
     //打印图片现在参数
     System.out.println("坐标1："+x1+":"+y1);
     System.out.println("坐标2："+x2+":"+y2);
     System.out.println("坐标3："+x3+":"+y3);
     System.out.println("坐标4："+x4+":"+y4);
     
     
     double width = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)); 
     System.out.println("图片宽度："+width);
     // 缩放比率判断  
     if (width < widthScreen  || width > widthScreen * 30) 
     {  
    	 System.out.println("传进来的宽度："+widthScreen);
    	 System.out.println("返回false");
         return false;  
     }  
     // 出界判断  
   
    if (x1>0 || x2<widthScreen || y1>0 ||y3<heightScreen) {  
         return false;  
     } 
   
     return true;  
 }  
 
 
 /*//根据名称从Assets中提取图片 缩略图
 public static Bitmap getSmallBitmapFromAssets(Context context,String name)
 {
 
	 int width=0;
	 int height=0;
	 WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

     width = wm.getDefaultDisplay().getWidth();
     height = wm.getDefaultDisplay().getHeight();
     *//**
      * 根据不同分辨率设置不同的缩略图
      *//*
     if(width>480)
     {
    	 width=60;
    	 height=60;
     }
     else
     {
    	 width=30;
    	 height=30; 
     }
	 Matrix matrix=new Matrix();
	 
	 try {
	    BufferedInputStream bis = new BufferedInputStream(context.getAssets().open(name+"SMALL.jpg"));
	    Bitmap bmp = BitmapFactory.decodeStream(bis);
	    
	    float scalex=(float)width/bmp.getWidth();
  	    float scaley=(float)height/bmp.getHeight();
  	  //在x轴和y轴上都放大fx倍，等比缩放
  	     matrix.setScale(scalex, scaley, 0, 0);
  	     Bitmap bitmap =Bitmap.createBitmap(width,height,  Config.RGB_565); // 背景图片  
  	         Canvas canvas = new Canvas(bitmap); // 新建画布  
  	       canvas.drawBitmap(bmp, matrix, null); // 画图片  
  	       Paint paint=new Paint();
	          paint.setColor(Color.RED);
	          paint.setStyle(Style.STROKE);//空心矩形
	          paint.setStrokeWidth(5);
	          canvas.drawRect(new Rect(0, 0, width, height), paint);
  	          
  	          
  	          canvas.save(Canvas.ALL_SAVE_FLAG); // 保存画布  
  	         canvas.restore(); 
	    
	    
	    return bitmap;

	   } catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    System.out.println("==========file not found======");
	    return null;
	   }
 }
 */
 
 //根据名称从Assets中提取图片 大图
 public static Bitmap getBigBitmapFromAssets(Context context,String name)
 {
 
	
	 
	 try {
	    BufferedInputStream bis = new BufferedInputStream(context.getAssets().open(name+"BIG.jpg"));
	    Bitmap bmp = BitmapFactory.decodeStream(bis);
	    
	   
	    
	    
	    return bmp;

	   } catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    System.out.println("==========file not found======");
	    return null;
	   }
 }
 

 //public static Bitmap getBitmapFromDrawable(Context context,)
 
 
 //吧设置好的sharepreference的xml文件添加到share目录
 public static boolean copyXMLTosharedPreferences(Context context) throws IOException
 {
	// int bytesum = 0; 
     int byteread = 0;
	 AssetManager assetManager =context.getAssets();
	 BufferedInputStream bis=new BufferedInputStream(assetManager.open("HEHE.xml"));
	 File oldfile = new File("//data//data//"+context.getApplicationContext().getPackageName()+"//shared_prefs//HEHE.xml");
	 
	 if(!oldfile.getParentFile().exists())
	 {
		 oldfile.getParentFile().mkdirs();
	 }
	 
	try{ if (oldfile.exists())
	 {
		 oldfile.delete();
	 }
	 FileOutputStream fs = new FileOutputStream(oldfile);
	 byte[] buffer = new byte[1024]; 
     
     while ( (byteread = bis.read(buffer)) != -1) { 
          //bytesum += byteread; //字节数 文件大小 
         //System.out.println(bytesum); 
         fs.write(buffer, 0, byteread); 
     } 
     fs.flush(); 
     fs.close(); 
     bis.close(); 
	 return true;
	}
	catch(Exception e)
	{
		System.out.println("写入文件错误");
		 return false;
		 
	}
 }
 
 
 public static Bitmap getMap(Context context,int resId)
 {
	       BitmapFactory.Options opt = new BitmapFactory.Options();  
	       opt.inPreferredConfig = Bitmap.Config.RGB_565;   
	       opt.inPurgeable = true;  
	       opt.inInputShareable = true;  
	         //获取资源图片  
	       InputStream is = context.getResources().openRawResource(resId); 
	       Bitmap bmp=BitmapFactory.decodeStream(is,null,opt);
	       Bitmap bitmap=Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(),Config.RGB_565); 
	       
	         Canvas canvas = new Canvas(bitmap); // 新建画布  
	        
	         canvas.drawBitmap(bmp, 0, 0, null);
	         //画边缘
	          Paint paint=new Paint();
	          paint.setColor(Color.argb(128, 0, 100, 255));
	          paint.setStyle(Style.STROKE);//空心矩形
	          paint.setStrokeWidth(50);
	          canvas.drawRect(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), paint);
	          canvas.save(Canvas.ALL_SAVE_FLAG); // 保存画布  
	 	      canvas.restore();
	         
	       
	         return bitmap; 
 }
 
 


}
