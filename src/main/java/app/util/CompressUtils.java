package app.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.*;

public class CompressUtils {

    /**
     * 把字节数组转换成16进制字符串
     *
     * @param bArray
     * @return
     */
    public static String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }


    /***
     * 压缩GZip
     *
     * @param data
     * @return
     */
    public static byte[] gZip(byte[] data) {
        byte[] b = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(bos);
            gzip.write(data);
            gzip.finish();
            gzip.close();
            b = bos.toByteArray();
            bos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return b;
    }

    /***
     * 解压GZip
     *
     * @param data
     * @return
     */
    public static byte[] unGZip(byte[] data) {
        byte[] b = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            GZIPInputStream gzip = new GZIPInputStream(bis);
            byte[] buf = new byte[1024];
            int num = -1;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((num = gzip.read(buf, 0, buf.length)) != -1) {
                baos.write(buf, 0, num);
            }
            b = baos.toByteArray();
            baos.flush();
            baos.close();
            gzip.close();
            bis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return b;
    }


    /***
     * 压缩Zip
     *
     * @param data
     * @return
     */
    public static byte[] zip(byte[] data) {
        byte[] b = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ZipOutputStream zip = new ZipOutputStream(bos);
            ZipEntry entry = new ZipEntry("zip");
            entry.setSize(data.length);
            zip.putNextEntry(entry);
            zip.write(data);
            zip.closeEntry();
            zip.close();
            b = bos.toByteArray();
            bos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return b;
    }

    /***
     * 解压Zip
     *
     * @param data
     * @return
     */
    public static byte[] unZip(byte[] data) {
        byte[] b = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            ZipInputStream zip = new ZipInputStream(bis);
            while (zip.getNextEntry() != null) {
                byte[] buf = new byte[1024];
                int num = -1;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                while ((num = zip.read(buf, 0, buf.length)) != -1) {
                    baos.write(buf, 0, num);
                }
                b = baos.toByteArray();
                baos.flush();
                baos.close();
            }
            zip.close();
            bis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return b;
    }

    /*   *//***
     * 压缩BZip2
     *
     * @param data
     * @return
     *//*
    public static byte[] bZip2(byte[] data) {
        byte[] b = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            CBZip2OutputStream bzip2 = new CBZip2OutputStream(bos);
            bzip2.write(data);
            bzip2.flush();
            bzip2.close();
            b = bos.toByteArray();
            bos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return b;
    }

    *//***
     * 解压BZip2
     *
     * @param data
     * @return
     *//*
    public static byte[] unBZip2(byte[] data) {
        byte[] b = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            CBZip2InputStream bzip2 = new CBZip2InputStream(bis);
            byte[] buf = new byte[1024];
            int num = -1;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((num = bzip2.read(buf, 0, buf.length)) != -1) {
                baos.write(buf, 0, num);
            }
            b = baos.toByteArray();
            baos.flush();
            baos.close();
            bzip2.close();
            bis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return b;
    }




    *//**
     *jzlib 压缩数据
     *
     * @param object
     * @return
     * @throws IOException
     *//*
    public static byte[] jzlib(byte[] object) {
        byte[] data = null;
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ZOutputStream zOut = new ZOutputStream(out,
                    JZlib.Z_DEFAULT_COMPRESSION);
            DataOutputStream objOut = new DataOutputStream(zOut);
            objOut.write(object);
            objOut.flush();
            zOut.close();
            data = out.toByteArray();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    */

    /**
     * jzLib压缩的数据
     *
     * @param
     * @return
     * @throws
     *//*
    public static byte[] unjzlib(byte[] object) {
        byte[] data = null;
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(object);
            ZInputStream zIn = new ZInputStream(in);
            byte[] buf = new byte[1024];
            int num = -1;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((num = zIn.read(buf, 0, buf.length)) != -1) {
                baos.write(buf, 0, num);
            }
            data = baos.toByteArray();
            baos.flush();
            baos.close();
            zIn.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }*/
    public static void main(String[] args) {
        String s = "{\"infodatas\":[{\"infodataId\":75,\"infodataSortorder\":35,\"infodataSubject\":\"书香、果香、菜香 赣南村庄生活“活色生香”\",\"infodataDesc\":\"赣南村庄\",\"infodataTxdate\":\"2018-08-09 00:00:00\",\"infodataCatcd\":\"新闻资讯\",\"infodataImg\":\"infodataimg_20180829160606_46645.png\",\"infodataCdate\":\"2018-08-29 16:06:06\",\"infodataCuser\":\"SZADM\",\"infodataAdate\":\"2018-08-29 16:06:06\",\"infodataAuser\":\"SZADM\",\"infodataContent\":\"2017年，距《国务院关于赣南等原中心苏区复兴展开的若干意见》出台已五年，这五年来，赣州一向把处理杰出民生问题作为复兴展开的首要任务。而村庄作为民生问题杰出之地，现在发生了哪些改变？\\r\\n　　曾经提起村庄日子，我们的印象往往是生态优秀但挣钱途径少，业余日子匮乏等等。现在，跟着基础设施逐步完善、互联网进村入镇，赣南村庄在不丢生态优势的一起，展开起果业、电商等，拓展了大众的挣钱途径；鼓起“农家书屋”、戏曲等，丰厚了大众的业余文明日子，村庄日子已大变样。近来，本网走进赣南安远县村庄，发现这儿由书香、果香、菜香一起调合出了“活色生香”的村庄日子。\\r\\n\\r\\n　　果香：多果飘香脐橙不再是仅有\\r\\n　　提到赣南果香，我们首要想起来的就是赣南脐橙的甜香，这种生果已成赣南的手刺，2016年其以668.11亿元的品牌价值，再次荣膺初级农产品地舆标志区域品牌价值第一，显示了它的品牌价值和其在富民方面的不俗实力。能够说这几年在赣南，“要想富，就种果”已成为一种一致。\\r\\n　　但近些年来“柑橘黄龙病”导致脐橙减产，果农收入减少，富民力度打了“折扣”，怎么办？安远县的做法是在活跃防控病害的一起，安排果农转产。\\r\\n　　80后大学毕业生谢意就是在这次转产中从本来的脐橙大户，变成了安远县镇岗乡黄洞村桃园山庄的“庄主”。\\r\\n　　2006年，谢意辞去本来的作业回到老家栽培脐橙，合理工作干得如火如荼的时分，他的果树成为了“柑橘黄龙病”侵袭下的牺牲品。多年心血付之东流，谢意心痛不已，痛定思痛之后，他决议呼应政府转产的召唤。经过多方调查证明，2013年，谢意挑选了鹰嘴桃作为工作的又一起点，桃苗种下，桃花怒放，硕果结出，2016年他喜获丰收，年收入达20多万元。而他本年的收成也已显示在了六月安远县镇岗乡黄洞村山头，那挂满枝头的青绿色的鹰嘴桃上，谢意的“生意合伙人”叔叔谢福泉介绍，这桃子下个月就能够采摘了，估计零售价能卖到15元一斤。\\r\\n　　与谢意同享这乡间桃香的还有邻近的乡民。2014年，谢意动员宗族栽培户一起筹资树立安远县黄洞农人专业合作社和黄洞村鹰嘴桃扶贫基地，经过“合作社+基地+农户”方法，吸纳本村20户农户参股入社，还供给了30多个工作岗位给贫困户，每月为他们发放3万多元薪酬。本年2月，又有24名困难大众加入这个“我们庭”。与此一起，该基地还经过免费赠送种苗、展开栽培训练、进行保护价收买等方法，带动周边村庄大众展开鹰嘴桃工业。2016年以来，基地赠送种苗2万余株，带动63户大众栽培鹰嘴桃。\\r\\n　　镇岗乡乡长巴志松说，除了鹰嘴桃外，为了确保脐橙和其他生果的优秀质量，该乡许多果农都已转产，实施轮种制，几年种脐橙几年种别的生果。\\r\\n　　现在的村庄，脐橙的甜香味不再是仅有的果香味，除了鹰嘴桃外，上一年，安远县转产栽培猕猴桃、百香果1.56万亩。各类生果不断飘香的一起，农业工业结构也在不断优化。\\r\\n\\r\\n\\r\\n　　书香：家门口就能够看书文明不再远\\r\\n　　走进凤山乡东河村电子商务效劳站，靠墙的两排大书架颇有目共睹，乡民代璐璐正在�\n" +
                "2018-12-18 12:04:10.520 9664-9745/com.yf.yftrace.app.dev D/OkHttp: :\"A\",\"messEffdate\":\"2018-12-01 13:24:00\",\"messEfftime\":\"132\",\"messExpdate\":\"2018-12-31 13:24:00\",\"messExptime\":\"132\",\"messGroup\":\"A\",\"messLoginid\":null,\"messHeading\":\"弘扬中华传统农耕技术 “老祖琚”赣南脐橙果园身体力行\",\"messContent\":\"随着经济的发展，人们对于吃的观念由吃饱转向了吃好。要吃的健康，就必须保证食品的安全无污染，绿色有机。中华传统农耕技术保证绿色有机的种植理念，非常符合现在人们的观念，目前使用传统种植技术去管理菜园、果园已经成为一种趋\\r\\n　　“老祖琚”最早是2009年在江西省赣州市信丰县小河镇罗坑村开辟果园，果园地处全国知名的“赣南脐橙”核心种植地，果园规模由当初不足70亩逐步发展到现在近500亩，整个过程艰辛而漫长。2012年确定将公司自有果园建成实验示范基地，引进“高频农业铠甲系列”技术，有了高科技的保驾护航，民族传统农业的深厚底蕴彻底爆发了，在严格按照传统的技术养护果园后，创造成年果树单株挂果406斤，该记录至今无人打破。联合国粮农组织官员认为该技术已经成熟，市场潜力极其广阔，运用该技术生产出的农产品完全符合欧盟现行的标准。通过多年艰辛的努力和技术的积累，产品走向市场已经是水到渠成的事情，在中国目前的农产品领域里，都在宣传绿色、有机、天然的概念，但如何做到绿色、有机、天然却没有人能够说清楚，“老祖琚”是第一家阐述清楚了的，这个是公司后期立足市场的核心竞争力。\\r\\n　　中国农业发展史比我们民族的文明史还要历史悠久，底蕴相当深厚，中华传统农耕技术符合现代人绿色健康的饮食观点，禁用化肥、农药，采用生物学方法灭虫等等也正是“老祖琚”赣南脐橙的种植管理理念。\\r\\n　　“老祖琚”希望通过自有核心技术，给“赣南脐橙”这一品牌注入新的活力，完成品牌升级的历史使命，带动地区乃至整个农业生产方式的变革。公司也会一直弘扬中华传统农耕技术，预备从2017年开始，种植面积每年增长一倍，力争用5年的时间打造2万亩的脐橙种植基地，到那时让每个老百姓吃到正真意义上的“生态、绿色、安全、廉价”水果，这是“老祖琚”对全社会的承诺!\",\"messCdate\":\"2018-12-01 13:24:23\",\"messCuser\":\"ADMIN@YUFENG.COM\",\"messAdate\":\"2018-12-12 11:19:40\",\"messAuser\":\"ADMIN@YUFENG.COM\",\"messEffdateStr\":\"2018-12-0\"},{\"messId\":533,\"messStatus\":\"A\",\"messEffdate\":\"2018-12-01 13:24:00\",\"messEfftime\":\"132\",\"messExpdate\":\"2018-12-31 13:24:00\",\"messExptime\":\"132\",\"messGroup\":\"A\",\"messLoginid\":null,\"messHeading\":\"纷纷找地种脐橙，你知道大果园管理难点吗？谈今年赣南脐橙订购价\",\"messContent\":\"笔者获悉，现在赣南很多人都在找地种脐橙，准备转型做农业。土地流转在赣南大地似乎迅速火了起来。笔者身边就有些朋友在找合适的土地，准备种植赣南脐橙。土地流转突然火了起来，据笔者分析，主要有三个原因：\\r\\n1、 最近5年，赣南脐橙品牌价值高，价格坚挺，赚钱效应明显；\\r\\n2、 国家政策鼓励土地流转，鼓励规模化农场的投资发展，政策引导效应；\\r\\n3、 同时，最近几年传统制造业艰难，部分制造业资本正在向农业转移。\\r\\n资本正在流向农业，我们可以看到上千亩的果园越来越多，很多人以为只要有资本就好办，果真如此吗？大农场管理的真正难点在哪里呢？\\r\\n1、 人工难请：\\r\\n赣南丘陵山地多，机械化水平不高，锄草、施肥、摸梢、修剪、打药处处都要请人，因为作业比较辛苦，人工难请这是共识；最难请的应该是修剪工人了，因为这个有一定的技术含量，果园越大，请的人就越多，而修剪对果树来说又是很重要的，直接跟产量�\n" +
                "2018-12-18 12:04:10.521 9664-9745/com.yf.yftrace.app.dev D/OkHttp: 面积、产量、产值稳居湖南省第一位。而就在今年4月，湖南省委副书记、省长许达哲在新宁县调研时，特别提出了“百里脐橙连崀山”的发展理念，这也使新宁县委、县政府更加坚定了整合产业资源、推动产业互融发展的信心和决心。\\r\\n\\r\\n为了更好地树立新宁崀山脐橙品牌，拓宽崀山脐橙的销售渠道，新宁县委、县政府创新思路，积极拓展崀山脐橙电商网销渠道。近几年，随着电商的不断发展，崀山脐橙销售已经从线下走到线上，实现了线上线下有效结合，2017年通过网上直接销售脐橙12万吨，通过线上撮合交易10万吨。\\r\\n\\r\\n“县委、县政府十分重视农产品上行电商化，将通过电商化销售对品质、包装、运输等高标准要求，倒逼崀山脐橙产业从种植、采摘、挑选、包装、仓储、物流等各个环节形成标准化，加大网络营销推广，扩大崀山脐橙品牌影响力，拓展销售渠道，将崀山脐橙打造成新宁‘一县一品’、‘一乡一品’的惠民致富产业，使崀山脐橙成为新宁农民致富的源动力。” 李荣卫介绍说。\\r\\n\\r\\n在一阵鸣笛声中，装满脐橙的邮政大货车发车启程，象征着今年的崀山脐橙电商销售正式首发，一箱箱新鲜采摘的崀山脐橙将通过电商平台销往全国各地。\\r\\n\\r\\n\\r\\n（装满脐橙的邮政大货车发车启程）\\r\\n\\r\\n此次崀山脐橙节，惠农网还组织邀请了京东湖南扶贫馆、湖南网上供销社、天猫淘乡甜、贝店、苏宁易购、百果园、步步高、芙蓉兴盛等50余家电商平台代表来到崀山，现场考察崀山脐橙选果、分级、包装、加工等供应链环节，并与基地优质供应商面对面交流，实现产销对接。\",\"messCdate\":\"2018-12-01 13:23:34\",\"messCuser\":\"ADMIN@YUFENG.COM\",\"messAdate\":\"2018-12-01 13:23:34\",\"messAuser\":\"ADMIN@YUFENG.COM\",\"messEffdateStr\":\"2018-12-0\"},{\"messId\":529,\"messStatus\":\"A\",\"messEffdate\":\"2018-12-01 13:22:00\",\"messEfftime\":\"132\",\"messExpdate\":\"2018-12-31 13:22:00\",\"messExptime\":\"132\",\"messGroup\":\"A\",\"messLoginid\":null,\"messHeading\":\"太壕！为了让你尽快吃上赣南脐橙，顺丰在当地果园建“停机坪”\",\"messContent\":\"双11这天一大早，赣州市南康区大坪乡的许社长就来到了他的脐橙园。由于搞活动促销，脐橙半天时间就卖出了几百份，他得尽快把货发出去。\\r\\n选摘好的橙子一箱箱码在树下，等着邓有森检查。邓有森是顺丰的快递员，负责这一区域的快递收发。他挨箱检查，封装、用手机下单、贴好标签。之后封好的箱子被搬到不远处的一片空地附近。那里，无人机操作员会把这些箱子四个一组，装在一架架八轴的“方舟”无人机上。在众人的注视下，无人机起飞，在空中慢慢缩小为一个个黑点，消失在人们的视线里。\\r\\n\\r\\n“现在好了，差不多2天他们就能收到了。”许兴奋地说。\\r\\n\\r\\n南康区，地处南岭山系罗霄山脉和大庾岭山脉的交界处，空气湿润，长出来的橙子皮薄肉甜，特别受欢迎。但是山多的地方，路就不好走。往年，橙子发出去得一周多才能到客户手里，由于时间太长有些果子不新鲜了还老被投诉。\\r\\n\\r\\n但今年不一样了。顺丰当在他的果园里开辟了一块无人机起降台。装好的脐橙直接被送到南康区无人机运营中心。那里的无人机调度室里，机长一名机长和两名辅助人员在远程操控着这些无人机。\\r\\n\\r\\n那里也是顺丰在南康的一个大的集散中心，脐橙会被再次装箱，一些通过汽车运输走高速直发上海等地，另一些则通过铁路送往各地。据了解，从赣南脐橙产地到厦门消费者手中，整个运输耗时不超24小时。\\r\\n\\r\\n对所有人“可及”\\r\\n\\r\\n从许社长的脐橙园，到南康区的集散中心，汽车至少要绕1个小时的山路，\n" +
                "2018-12-18 12:04:10.521 9664-9745/com.yf.yftrace.app.dev D/OkHttp: 位于高排村某山场林某的果园内，有人在光天化日之下偷脐橙。民警赶到现场后得知，事主在果园内巡查时，只看见一个人影一闪而过，并发现了地上零星堆放的脐橙，还有一辆无牌的摩托车。经过现场巡查，并未发现嫌疑人，民警勘察完现场后把涉案物品带回派出所进一步调查。很明显，几堆脐橙，一辆摩托车，还有装脐橙用的蛇皮袋，这是一起盗窃脐橙案件。但现场未发现其他有价值的线索，如何破获该案？办案民警根据摩托车的型号和装饰物，辗转查到了出售此类车辆的销售点和经销商，并让其将近几年购买该车辆的车主信息一并找出，最终经过几天的核对，查询到嫌疑车主刘某。在公安机关强大的压力下，11月21日，刘某来到高排派出所投案自首。\",\"messCdate\":\"2018-12-01 13:21:28\",\"messCuser\":\"ADMIN@YUFENG.COM\",\"messAdate\":\"2018-12-01 13:21:28\",\"messAuser\":\"ADMIN@YUFENG.COM\",\"messEffdateStr\":\"2018-12-0\"},{\"messId\":526,\"messStatus\":\"A\",\"messEffdate\":\"2018-12-01 13:17:00\",\"messEfftime\":\"1317\",\"messExpdate\":\"2018-12-31 13:17:00\",\"messExptime\":\"1317\",\"messGroup\":\"A\",\"messLoginid\":null,\"messHeading\":\"村民家门口果园务工 有了稳定月收入\",\"messContent\":\"11月29日，在重庆市大足区中敖镇明月村玉皇沟果园里，一些当地留守妇女正在把刚摘下的杂柑装入包装箱。她们在果园务工，一年四季都有工作。一名当地妇女在果园务工。\\r\\n\\r\\n“我的家就在附近，差不多每天都来上班，不担心没的事情多，现在是杂柑成熟期，每天会比较忙一些，明年夏天的时候杂柑摘完了，我们就除草，施肥，剪枝，工作还是有的。”一名妇女透露，她每个月领固定工资，为2千元。\\r\\n\\r\\n玉皇沟果园占地650亩，出产的由柑和橙杂交的杂柑口感优，很受市场欢迎，借助电子商务平台销售，杂柑每天源源不断地销往全国各地，因而果园工作很多，雇佣工人人数最多的时候达到100余人，不过，本地村民成为优先聘用对象，工人基本都是本地的留守妇女和空巢老人。\\r\\n\\r\\n这里实行月薪制，每人每月工资2千元，村民笑言自己成了有稳定月收入的上班族。由于果园水果不愁销售，工人因而也不用担心薪酬会被拖欠，工人对于在家门口上班普遍感到满意。\",\"messCdate\":\"2018-12-01 13:17:43\",\"messCuser\":\"ADMIN@YUFENG.COM\",\"messAdate\":\"2018-12-01 13:17:43\",\"messAuser\":\"ADMIN@YUFENG.COM\",\"messEffdateStr\":\"2018-12-0\"}]}\n" +
                "2018-12-18 12:04:10.521 9664-9745/com.yf.yftrace.app.dev D/OkHttp: <-- END HTTP (30396-byte body)\n" +
                "2018-12-18 12:04:10.526 9664-9744/com.yf.yftrace.app.dev D/OkHttp: {\"infodatas\":[{\"infodataId\":75,\"infodataSortorder\":35,\"infodataSubject\":\"书香、果香、菜香 赣南村庄生活“活色生香”\",\"infodataDesc\":\"赣南村庄\",\"infodataTxdate\":\"2018-08-09 00:00:00\",\"infodataCatcd\":\"新闻资讯\",\"infodataImg\":\"infodataimg_20180829160606_46645.png\",\"infodataCdate\":\"2018-08-29 16:06:06\",\"infodataCuser\":\"SZADM\",\"infodataAdate\":\"2018-08-29 16:06:06\",\"infodataAuser\":\"SZADM\",\"infodataContent\":\"2017年，距《国务院关于赣南等原中心苏区复兴展开的若干意见》出台已五年，这五年来，赣州一向把处理杰出民生问题作为复兴展开的首要任务。而村庄作为民生问题杰出之地，现在发生了哪些改变？\\r\\n　　曾经提起村庄日子，我们的印象往往是生态优秀但挣钱途径少，业余日子匮乏等等。现在，跟着基础设施逐步完善、互联网进村入镇，赣南村庄在不丢生态优势的一起，展开起果业、电商等，拓展了大众的挣钱途径；鼓起“农家书屋”、戏曲等，丰厚了大众的业余文明日子，村庄日子已大变样。近来，本网走进赣南安远县村庄，发现这儿由书香、果香、菜香一起调合出了“活色生香”的村庄日子。\\r\\n\\r\\n　　果香：多果飘香脐橙不再是仅有\\r\\n　　提到赣南果香，我们首要想起来的就是赣南脐橙的甜香，这种生果已成赣南的手刺，2016年其以668.11亿元的品牌价值，再次荣膺初级农产品地舆标志区域品牌价值第一，显示了它的品牌价值和其在富民方面的不俗实力。能够说这几年在赣南，“要想富，就种果”已成为一种一致。\\r\\n　　但近些年来“柑橘黄龙病”导致脐橙减产，果农收入减少，富民力度打了“折扣”，怎么办？安远县的做法是在活跃防控病害的一起，安排果农转产。\\r\\n　　80后大学毕业生谢意就是在这次转产中从本来的脐橙大户，变成了安远县镇岗乡黄洞村桃园山庄的“庄主”。\\r\\n　　2006年，谢意辞去本来的作业回到老家栽培脐橙，合理工作干得如火如荼的时分，他的果树成为了“柑橘黄龙病”侵袭下的牺牲品。多年心血付之东流，谢意心痛不已，痛定思痛之后，他决议呼应政府转产的召唤。经过多方调查证明，2013年，谢意挑选了鹰嘴桃作为工作的又一起点，桃苗种下，桃花怒放，硕果结出，2016年他喜获丰收，年收入达20多万元。而他本年的收成也已显示在了六月安远县镇岗乡黄洞村山头，那挂满枝头的青绿色的鹰嘴桃上，谢意的“生意合伙人”叔叔谢福泉介绍，这桃子下个月就能够采摘了，估计零售价能卖到15元一斤。\\r\\n　　与谢意同享这乡间桃香的还有邻近的乡民。2014年，谢意动员宗族栽培户一起筹资树立安远县黄洞农人专业合作社和黄洞村鹰嘴桃扶贫基地，经过“合作社+基地+农户”方法，吸纳本村20户农户参股入社，还供给了30多个工作岗位给贫困户，每月为他们发放3万多元薪酬。本年2月，又有24名困难大众加入这个“我们庭”。与此一起，该基地还经过免费赠送种苗、展开栽培训练、进行保护价收买等方法，带动周边村庄大众展开鹰嘴桃工业。2016年以来，基地赠送种苗2万余株，带动63户大众栽培鹰嘴桃。\\r\\n　　镇岗乡乡长巴志松说，除了鹰嘴桃外，为了确保脐橙和其他生果的优秀质量，该乡许多果农都已转产，实施轮种制，几年种脐橙几年种别的生果。\\r\\n　　现在的村庄，脐橙的甜香味不再是仅有的果香味，除了鹰嘴桃外，上一年，安远县转产栽培猕猴桃、百香果1.56万亩。各类生果不断飘香的一起，农业工业结构也在不断优化。\\r\\n\\r\\n\\r\\n　　书香：家门口就能够看书文明不再远\\r\\n　　走进凤山乡东河村电子商务效劳站，靠墙的两排大书架颇有目共睹，乡民代璐璐正在�\n" +
                "2018-12-18 12:04:10.526 9664-9744/com.yf.yftrace.app.dev D/OkHttp: :\"A\",\"messEffdate\":\"2018-12-01 13:24:00\",\"messEfftime\":\"132\",\"messExpdate\":\"2018-12-31 13:24:00\",\"messExptime\":\"132\",\"messGroup\":\"A\",\"messLoginid\":null,\"messHeading\":\"弘扬中华传统农耕技术 “老祖琚”赣南脐橙果园身体力行\",\"messContent\":\"随着经济的发展，人们对于吃的观念由吃饱转向了吃好。要吃的健康，就必须保证食品的安全无污染，绿色有机。中华传统农耕技术保证绿色有机的种植理念，非常符合现在人们的观念，目前使用传统种植技术去管理菜园、果园已经成为一种趋\\r\\n　　“老祖琚”最早是2009年在江西省赣州市信丰县小河镇罗坑村开辟果园，果园地处全国知名的“赣南脐橙”核心种植地，果园规模由当初不足70亩逐步发展到现在近500亩，整个过程艰辛而漫长。2012年确定将公司自有果园建成实验示范基地，引进“高频农业铠甲系列”技术，有了高科技的保驾护航，民族传统农业的深厚底蕴彻底爆发了，在严格按照传统的技术养护果园后，创造成年果树单株挂果406斤，该记录至今无人打破。联合国粮农组织官员认为该技术已经成熟，市场潜力极其广阔，运用该技术生产出的农产品完全符合欧盟现行的标准。通过多年艰辛的努力和技术的积累，产品走向市场已经是水到渠成的事情，在中国目前的农产品领域里，都在宣传绿色、有机、天然的概念，但如何做到绿色、有机、天然却没有人能够说清楚，“老祖琚”是第一家阐述清楚了的，这个是公司后期立足市场的核心竞争力。\\r\\n　　中国农业发展史比我们民族的文明史还要历史悠久，底蕴相当深厚，中华传统农耕技术符合现代人绿色健康的饮食观点，禁用化肥、农药，采用生物学方法灭虫等等也正是“老祖琚”赣南脐橙的种植管理理念。\\r\\n　　“老祖琚”希望通过自有核心技术，给“赣南脐橙”这一品牌注入新的活力，完成品牌升级的历史使命，带动地区乃至整个农业生产方式的变革。公司也会一直弘扬中华传统农耕技术，预备从2017年开始，种植面积每年增长一倍，力争用5年的时间打造2万亩的脐橙种植基地，到那时让每个老百姓吃到正真意义上的“生态、绿色、安全、廉价”水果，这是“老祖琚”对全社会的承诺!\",\"messCdate\":\"2018-12-01 13:24:23\",\"messCuser\":\"ADMIN@YUFENG.COM\",\"messAdate\":\"2018-12-12 11:19:40\",\"messAuser\":\"ADMIN@YUFENG.COM\",\"messEffdateStr\":\"2018-12-0\"},{\"messId\":533,\"messStatus\":\"A\",\"messEffdate\":\"2018-12-01 13:24:00\",\"messEfftime\":\"132\",\"messExpdate\":\"2018-12-31 13:24:00\",\"messExptime\":\"132\",\"messGroup\":\"A\",\"messLoginid\":null,\"messHeading\":\"纷纷找地种脐橙，你知道大果园管理难点吗？谈今年赣南脐橙订购价\",\"messContent\":\"笔者获悉，现在赣南很多人都在找地种脐橙，准备转型做农业。土地流转在赣南大地似乎迅速火了起来。笔者身边就有些朋友在找合适的土地，准备种植赣南脐橙。土地流转突然火了起来，据笔者分析，主要有三个原因：\\r\\n1、 最近5年，赣南脐橙品牌价值高，价格坚挺，赚钱效应明显；\\r\\n2、 国家政策鼓励土地流转，鼓励规模化农场的投资发展，政策引导效应；\\r\\n3、 同时，最近几年传统制造业艰难，部分制造业资本正在向农业转移。\\r\\n资本正在流向农业，我们可以看到上千亩的果园越来越多，很多人以为只要有资本就好办，果真如此吗？大农场管理的真正难点在哪里呢？\\r\\n1、 人工难请：\\r\\n赣南丘陵山地多，机械化水平不高，锄草、施肥、摸梢、修剪、打药处处都要请人，因为作业比较辛苦，人工难请这是共识；最难请的应该是修剪工人了，因为这个有一定的技术含量，果园越大，请的人就越多，而修剪对果树来说又是很重要的，直接跟产量�\n" +
                "2018-12-18 12:04:10.526 9664-9744/com.yf.yftrace.app.dev D/OkHttp: 面积、产量、产值稳居湖南省第一位。而就在今年4月，湖南省委副书记、省长许达哲在新宁县调研时，特别提出了“百里脐橙连崀山”的发展理念，这也使新宁县委、县政府更加坚定了整合产业资源、推动产业互融发展的信心和决心。\\r\\n\\r\\n为了更好地树立新宁崀山脐橙品牌，拓宽崀山脐橙的销售渠道，新宁县委、县政府创新思路，积极拓展崀山脐橙电商网销渠道。近几年，随着电商的不断发展，崀山脐橙销售已经从线下走到线上，实现了线上线下有效结合，2017年通过网上直接销售脐橙12万吨，通过线上撮合交易10万吨。\\r\\n\\r\\n“县委、县政府十分重视农产品上行电商化，将通过电商化销售对品质、包装、运输等高标准要求，倒逼崀山脐橙产业从种植、采摘、挑选、包装、仓储、物流等各个环节形成标准化，加大网络营销推广，扩大崀山脐橙品牌影响力，拓展销售渠道，将崀山脐橙打造成新宁‘一县一品’、‘一乡一品’的惠民致富产业，使崀山脐橙成为新宁农民致富的源动力。” 李荣卫介绍说。\\r\\n\\r\\n在一阵鸣笛声中，装满脐橙的邮政大货车发车启程，象征着今年的崀山脐橙电商销售正式首发，一箱箱新鲜采摘的崀山脐橙将通过电商平台销往全国各地。\\r\\n\\r\\n\\r\\n（装满脐橙的邮政大货车发车启程）\\r\\n\\r\\n此次崀山脐橙节，惠农网还组织邀请了京东湖南扶贫馆、湖南网上供销社、天猫淘乡甜、贝店、苏宁易购、百果园、步步高、芙蓉兴盛等50余家电商平台代表来到崀山，现场考察崀山脐橙选果、分级、包装、加工等供应链环节，并与基地优质供应商面对面交流，实现产销对接。\",\"messCdate\":\"2018-12-01 13:23:34\",\"messCuser\":\"ADMIN@YUFENG.COM\",\"messAdate\":\"2018-12-01 13:23:34\",\"messAuser\":\"ADMIN@YUFENG.COM\",\"messEffdateStr\":\"2018-12-0\"},{\"messId\":529,\"messStatus\":\"A\",\"messEffdate\":\"2018-12-01 13:22:00\",\"messEfftime\":\"132\",\"messExpdate\":\"2018-12-31 13:22:00\",\"messExptime\":\"132\",\"messGroup\":\"A\",\"messLoginid\":null,\"messHeading\":\"太壕！为了让你尽快吃上赣南脐橙，顺丰在当地果园建“停机坪”\",\"messContent\":\"双11这天一大早，赣州市南康区大坪乡的许社长就来到了他的脐橙园。由于搞活动促销，脐橙半天时间就卖出了几百份，他得尽快把货发出去。\\r\\n选摘好的橙子一箱箱码在树下，等着邓有森检查。邓有森是顺丰的快递员，负责这一区域的快递收发。他挨箱检查，封装、用手机下单、贴好标签。之后封好的箱子被搬到不远处的一片空地附近。那里，无人机操作员会把这些箱子四个一组，装在一架架八轴的“方舟”无人机上。在众人的注视下，无人机起飞，在空中慢慢缩小为一个个黑点，消失在人们的视线里。\\r\\n\\r\\n“现在好了，差不多2天他们就能收到了。”许兴奋地说。\\r\\n\\r\\n南康区，地处南岭山系罗霄山脉和大庾岭山脉的交界处，空气湿润，长出来的橙子皮薄肉甜，特别受欢迎。但是山多的地方，路就不好走。往年，橙子发出去得一周多才能到客户手里，由于时间太长有些果子不新鲜了还老被投诉。\\r\\n\\r\\n但今年不一样了。顺丰当在他的果园里开辟了一块无人机起降台。装好的脐橙直接被送到南康区无人机运营中心。那里的无人机调度室里，机长一名机长和两名辅助人员在远程操控着这些无人机。\\r\\n\\r\\n那里也是顺丰在南康的一个大的集散中心，脐橙会被再次装箱，一些通过汽车运输走高速直发上海等地，另一些则通过铁路送往各地。据了解，从赣南脐橙产地到厦门消费者手中，整个运输耗时不超24小时。\\r\\n\\r\\n对所有人“可及”\\r\\n\\r\\n从许社长的脐橙园，到南康区的集散中心，汽车至少要绕1个小时的山路，\n" +
                "2018-12-18 12:04:10.527 9664-9744/com.yf.yftrace.app.dev D/OkHttp: 位于高排村某山场林某的果园内，有人在光天化日之下偷脐橙。民警赶到现场后得知，事主在果园内巡查时，只看见一个人影一闪而过，并发现了地上零星堆放的脐橙，还有一辆无牌的摩托车。经过现场巡查，并未发现嫌疑人，民警勘察完现场后把涉案物品带回派出所进一步调查。很明显，几堆脐橙，一辆摩托车，还有装脐橙用的蛇皮袋，这是一起盗窃脐橙案件。但现场未发现其他有价值的线索，如何破获该案？办案民警根据摩托车的型号和装饰物，辗转查到了出售此类车辆的销售点和经销商，并让其将近几年购买该车辆的车主信息一并找出，最终经过几天的核对，查询到嫌疑车主刘某。在公安机关强大的压力下，11月21日，刘某来到高排派出所投案自首。\",\"messCdate\":\"2018-12-01 13:21:28\",\"messCuser\":\"ADMIN@YUFENG.COM\",\"messAdate\":\"2018-12-01 13:21:28\",\"messAuser\":\"ADMIN@YUFENG.COM\",\"messEffdateStr\":\"2018-12-0\"},{\"messId\":526,\"messStatus\":\"A\",\"messEffdate\":\"2018-12-01 13:17:00\",\"messEfftime\":\"1317\",\"messExpdate\":\"2018-12-31 13:17:00\",\"messExptime\":\"1317\",\"messGroup\":\"A\",\"messLoginid\":null,\"messHeading\":\"村民家门口果园务工 有了稳定月收入\",\"messContent\":\"11月29日，在重庆市大足区中敖镇明月村玉皇沟果园里，一些当地留守妇女正在把刚摘下的杂柑装入包装箱。她们在果园务工，一年四季都有工作。一名当地妇女在果园务工。\\r\\n\\r\\n“我的家就在附近，差不多每天都来上班，不担心没的事情多，现在是杂柑成熟期，每天会比较忙一些，明年夏天的时候杂柑摘完了，我们就除草，施肥，剪枝，工作还是有的。”一名妇女透露，她每个月领固定工资，为2千元。\\r\\n\\r\\n玉皇沟果园占地650亩，出产的由柑和橙杂交的杂柑口感优，很受市场欢迎，借助电子商务平台销售，杂柑每天源源不断地销往全国各地，因而果园工作很多，雇佣工人人数最多的时候达到100余人，不过，本地村民成为优先聘用对象，工人基本都是本地的留守妇女和空巢老人。\\r\\n\\r\\n这里实行月薪制，每人每月工资2千元，村民笑言自己成了有稳定月收入的上班族。由于果园水果不愁销售，工人因而也不用担心薪酬会被拖欠，工人对于在家门口上班普遍感到满意。\",\"messCdate\":\"2018-12-01 13:17:43\",\"messCuser\":\"ADMIN@YUFENG.COM\",\"messAdate\":\"2018-12-01 13:17:43\",\"messAuser\":\"ADMIN@YUFENG.COM\",\"messEffdateStr\":\"2018-12-0\"}]}";

/*        byte[] b1 = zip(s.getBytes());
        System.out.println("zip:" + bytesToHexString(b1));

        byte[] b2 = unZip(b1);
        System.out.println("unZip:" + new String(b2));*/

        byte[] b5 = gZip(s.getBytes());
        System.out.println("length:" + b5.length);
        System.out.println("gZip:" + new String(b5));

        byte[] unb5 = unGZip(b5);
        System.out.println("unGZip:" + new String(unb5));

    }


}
