package sanguo.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author Alex
 * date 2018/6/24
 * description 对成员进行排官，排官规则：按战力值排，战力相差不超过5万的按贡献值排，排出指定数量的官位
 */
public class SortOfficer {
    /**
     * 业务逻辑：
     * 1、先对所给数据按战力进行降序排列；
     * 2、从所给数据中筛选出需要进行排官的对象，筛选方法：通过官位数量来确定这组数据中第（总官位数量）的战力，将战力-5万跟这个数据之后的
     * 数据进行比对，当后面数据的战力值小于或等于这个数字时就停止比对；
     * 3、找出官位成员，寻找方法：将第1个成员战力-5万跟最后一个成员战力进行比较，如果最后一个成员的战力大于或等于这个数字时，
     * 就将筛选出的数据按贡献进行降序排列，否则就开启逻辑2。逻辑2：将第1个成员的战力-5万依次跟后面的成员进行比较，当后面成员战力小于或等于
     * 这个数字时，比较终止，获取截止时符合条件的成员列表，如果成员列表数量小于或等于（总官位数量），则将第1个成员直接放进官位列表中，
     * 并将此成员从列表中删除，否则开启逻辑3。逻辑3：对符合条件的成员列表按贡献进行排序，贡献高者放进官位列表中，并将此成员从成员列表中删除。
     * 按照逻辑2之后的逻辑重复循环获取所需要数量的官位。
     */
    public static void main(String[] args) throws Exception {
        int officerNum = 14;//总官位数量
        int fightOffset = 50000;//战力相差值

        List<Person> list3 = new ArrayList<>();
        Person person = new Person(1, "叶血", 1169265, 303503);
        Person person1 = new Person(2, "绝世狂牛", 946883, 259873);
        Person person2 = new Person(3, "余先生", 969154, 217890);
        Person person3 = new Person(4, "东方嘉玉", 1073529, 205143);
        Person person4 = new Person(5, "天火", 913686, 240277);
        Person person5 = new Person(6, "皇军", 981162, 254803);
        //Person person6 = new Person(7, "木成林", 743951, 188073);
        Person person7 = new Person(8, "一统三国", 1079774, 216167);
        //Person person8 = new Person(9, "天火燎原", 731703, 125768);
        Person person9 = new Person(10, "壹筒叁国", 821039, 236162);
        Person person10 = new Person(11, "无爱", 912455, 220668);
        //Person person11 = new Person(12, "曜嘉", 699586, 91994);
        Person person12 = new Person(13, "天马行空", 795641, 237049);
        Person person13 = new Person(14, "惠波峻", 737053, 217755);
        Person person14 = new Person(15, "巫马沈雅", 809648, 240161);
        Person person15 = new Person(16, "幻想粥", 715559, 165657);
        //Person person16 = new Person(17, "枫少", 789904, 142525);
        Person person17 = new Person(18, "洛昕尘", 746417, 138697);
        Person person18 = new Person(19, "巴什卡群", 700480, 57744);
        //Person person19 = new Person(20, "上头", 653112, 113778);
        Person person20 = new Person(21, "喝whn", 738274, 243034);
        Person person21 = new Person(22, "乐迪", 854168, 13972);
        Person person22 = new Person(23, "西门弘懿", 650967, 99922);
        Person person23 = new Person(24, "海燕", 601498, 115172);
        Person person24 = new Person(25, "伯赏品韵", 600506, 30004);
        list3.add(person);
        list3.add(person1);
        list3.add(person2);
        list3.add(person3);
        list3.add(person4);
        list3.add(person5);
        //list3.add(person6);
        list3.add(person7);
        //list3.add(person8);
        list3.add(person9);
        list3.add(person10);
        //list3.add(person11);
        list3.add(person12);
        list3.add(person13);
        list3.add(person14);
        list3.add(person15);
        //list3.add(person16);
        list3.add(person17);
        list3.add(person18);
        //list3.add(person19);
        list3.add(person20);
        list3.add(person21);
        list3.add(person22);
        list3.add(person23);
        list3.add(person24);

        List<Person> personList = SortOfficer.sortDesc(list3);//获取排序后的军团成员对象列表
        Person officerNumPerson = personList.get(officerNum - 1);//获取第（官位总数量）个官员对象
        List<Person> candidateList = new ArrayList<>();
        for (int i = 0; i < personList.size(); i++) {
            Person persons = personList.get(i);//获取当前的军团成员对象
            if (officerNumPerson.getFightValue() - fightOffset < persons.getFightValue()) {//如果第（官位总数量）个官员对象战力小于当前军团成员对象的战力时，添加当前成员对象到官位候选成员列表，否则中止循环
                candidateList.add(persons);
            } else {
                break;
            }
        }

        List<Person> finalResult = new ArrayList<>();
        List<Person> result = SortOfficer.getFinalResult(candidateList, fightOffset, officerNum, finalResult);
        System.out.println("当前官位排列顺序为：");
        for (int t=0;t<result.size();t++) {
            System.out.println(result.get(t));
            if(t == officerNum/2 -1){
                System.out.println("");
            }
        }

    }

    /**
     * 获取最终结果集合
     *
     * @return
     */
    public static List<Person> getFinalResult(List<Person> candidateList, Integer fightOffset, Integer officerNum, List<Person> finalResult) {
        Person firstPerson = candidateList.get(0);//获取候选列表中第1个官员对象
        int compareFirstPersonFight = firstPerson.getFightValue() - fightOffset;
        Person lastPerson = candidateList.get(candidateList.size() - 1);//获取候选列表中最后一个官员对象
       /* if (compareFirstPersonFight <= lastPerson.getFightValue()) {//如果最后一个战力大于或等于第一位减去偏移值的战力，那么将候选列表按贡献值进行降序排列
            //这种可能性小的可怜，逻辑暂时不写了，后面有时间再写
        } else {*///否则，从候选列表中一个个找出所官员对象

        List<Person> candidateListFinal = SortOfficer.getCandidateListFinal(candidateList, compareFirstPersonFight);//获取最终的候选对象集合
        if (candidateListFinal.size() <= officerNum - finalResult.size()) {//如果最终候选人名单的数量小于或等于官位数量时，将第一个直接添加进最终集合，并从候选集合中去掉
            finalResult.add(firstPerson);//添加
            candidateList.remove(0);//去掉
        } else {//按照贡献进行排序
            Integer firstContribute = candidateListFinal.get(0).getContribute();
            Integer personId = candidateListFinal.get(0).getId();
            for (Person p1 : candidateListFinal) {//找到最大贡献的那个人
                if (p1.getContribute() > firstContribute) {
                    firstContribute = p1.getContribute();
                    personId = p1.getId();
                }
            }

            for (int k = 0; k < candidateList.size(); k++) {//将最大贡献的那人添加到最终结果列表中，然后从候选列表中移除
                if (candidateList.get(k).getId() == personId) {
                    finalResult.add(candidateList.get(k));
                    candidateList.remove(k);
                }
            }
        }

        //递归直到结果集中的个数等于官位数量为止
        if (finalResult.size() < officerNum) {
            SortOfficer.getFinalResult(candidateList, fightOffset, officerNum, finalResult);
        }
       /* }*/

        return finalResult;
    }

    /**
     * 获取最终的官员候选对象集合
     *
     * @return
     */
    public static List<Person> getCandidateListFinal(List<Person> candidateList, int compareFirstPersonFight) {
        List<Person> candidateListFinal = new ArrayList<>();
        for (int j = 0; j < candidateList.size(); j++) {
            if (compareFirstPersonFight < candidateList.get(j).getFightValue()) {//如果第1位偏移后的战力小于后面的战力，则将当前的官员对象添加进最终候选列表中
                candidateListFinal.add(candidateList.get(j));
            }
        }
        return candidateListFinal;
    }

    /**
     * 对集合中的数据按战力进行倒序排列
     *
     * @param people
     * @return
     */
    public static List<Person> sortDesc(List<Person> people) {
        Collections.sort(people);
        System.out.println("下面是所有人的战力排行情况：");
        for (Person p : people) {
            System.out.println(p);
        }
        return people;
    }
}
