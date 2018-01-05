package search.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import search.Parser;
import vo.Program;
import search.impl.WebSpiderImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParserImpl implements Parser {

    @Override
    public Program parseHtml(String html) {
        //多线程
        Program program = new Program();
        ExecutorService pool = Executors.newFixedThreadPool(4);
        ArrayList list = new ArrayList<>();
        try {
            Document doc = Jsoup.parse(new URL("http://studies.ku.dk"+html),50000);
            //项目名称
            Elements elements = doc.select("div");//得到table标签内的元素
            Elements linktext = elements.select("#main-content > h1");//得到带h1标签的元素
            //System.out.println(linktext.text());
            if(linktext.text().contains("in")) {
                program.setProgramName(linktext.text());
                System.out.println(program.getProgramName());
            }else {
                program.setProgramName("NULL");
            }

            //得到随机的id
            String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
            program.setId(uuid);
            //学校名称
            String university = "University of Copenhagen";
            program.setUniversity(university);
            //所在国家地区
            String country = "Copenhagen";
            program.setCountry(country);

            //开设学院
            String school;
            if(program.getProgramName().contains("Science")){
                school = "Faculty of Science";
            }
            else if(program.getProgramName().contains("Law")){
                school = "Faculty of Law";
            }
            else
            {
                school = "Faculty of Humanities";
            }
            program.setSchool(school);

            //学位
            String degree = "Master";
            program.setDegree(degree);

            //邮箱
            String email;
            if(Objects.equals(school, "Faculty of Science")){
                email = "science@science.ku.dk";
            }
            else if(Objects.equals(school,"Faculty of Law")){
                email = "jurfak@jur.ku.dk";

            }
            else{
                email = "sekretariat@hum.ku.dk";
            }
            program.setEmail(email);

            //电话
            String phone;
            if(Objects.equals(school, "Faculty of Science")){
                phone = "+45 35 33 28 28";
            }
            else if(Objects.equals(school,"Faculty of Law")){
                phone = "+45 35 32 26 26";

            }
            else{
                phone = "+45 35 32 88 11";
            }
            program.setPhoneNumber(phone);

            //地址
            String address;
            if(Objects.equals(school, "Faculty of Science")){
                address = "DK-1171 Copenhagen ";
            }
            else if(Objects.equals(school,"Faculty of Law")){
                address = "DK-2300 Copenhagen S ";

            }
            else{
                address = "Karen Blixens Plads 8, DK-2300 Copenhagen S ";
            }
            program.setLocation(address);

            //有奖ddl
            String ddl1 = "null";
            program.setDeadlineWithAid(ddl1);
            //无奖ddl
            String ddl2 = "null";
            program.setDeadlineWithoutAid(ddl2);
            //项目主页地址
            String home ="http://studies.ku.dk"+html;
            program.setHomepage(home);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return program;
    }
}
