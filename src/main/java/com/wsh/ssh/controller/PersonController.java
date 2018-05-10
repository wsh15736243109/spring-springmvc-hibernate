package com.wsh.ssh.controller;

import com.wsh.ssh.domain.PersonModel;
import com.wsh.ssh.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;



    @RequestMapping("/saveperson")
    public String addPerson(PersonModel personModel){
         personService.addPerson(personModel);
         return "redirect:main";
    }

    /**
     * 查询所有人员信息
     *
     * @param map 使用的是map保存回显数据
     * @return
     */
    @RequestMapping(value = "/main")
    public String mian(Map<String, Object> map) {
        map.put("personlist", personService.queryPerson());
		/*遍历集合，查看查询到的数据
		 * List<Person> lists = personService.getPersons();
		 * Iterator<Person> it = lists.iterator();
		 * while(it.hasNext()){
		 * 		Person p =it.next();
		 *	 	System.out.println(p.toString());
		 *  }
		 */
        return "main";
    }

    @RequestMapping("/toIndex")
    public String getJsp(){
        return "test_html";
    }

    /**
     * 跳转到添加页面
     * savepage.jsp
     * @return
     */
    @RequestMapping(value = "/addperson")
    public String saveperson() {

        return "savepage";
    }


    @RequestMapping("/deletePerson")
    public int deletePerson(String id){
        personService.deletePerson(id);
        return 0;
    }

    @RequestMapping("/updatePerson")
    public int updatePerson(PersonModel personModel){
        personService.updatePerson(personModel);
        return 0;
    }

    @RequestMapping("/getPersons")
    @ResponseBody
    public List<PersonModel> queryPerson(){
        return personService.queryPerson();
    }

    @RequestMapping("/queryPersonById")
    @ResponseBody
    public PersonModel queryPersonById(String id){
        return personService.queryPersonById(id);
    }
}
