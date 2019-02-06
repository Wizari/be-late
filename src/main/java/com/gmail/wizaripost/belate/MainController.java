package com.gmail.wizaripost.belate;

import com.wizaripost.losertime.logic.Employee;
import com.wizaripost.losertime.mail.IContentCreator;
import com.wizaripost.losertime.mail.IEmployeeProvider;
import com.wizaripost.losertime.mail.IMailApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;


@Controller
public class MainController {

//    @GetMapping("/")
//    public String main(Model model) {
//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee(true, "Алексеев"));
//        employees.add(new Employee(true, "Вфцц"));
//        employees.add(new Employee(true, "Вфыафа"));
//        employees.add(new Employee(true, "ППфцвф"));
//
////        for (Employee z : employees) {
//            for (int i = 0; i < employees.size(); i++) {
//
//            model.addAttribute("employees", employees.get(i).getName());
//
//        }
//
////        model.addAttribute("box", "Я ящик");
////        return "index.html";
//        return "employees.html";
//    }

    @Autowired
    private IEmployeeProvider employeeProvider;

    @Autowired
    private IMailApi mailApi;

    @Autowired
    private IContentCreator contentCreator;


    @GetMapping("/")
    public String main(Model model) {
        EmployeeContainer employeeContainer = new EmployeeContainer();
        List<Employee> employees = employeeProvider.getEmployees();
        employeeContainer.setEmployees(employees);
        model.addAttribute("employeeContainer", employeeContainer);
        return "index.html";
    }


//    @GetMapping("/get_request")
//    public String get4432(List<Employee> employees, Model model) {
//
//        String content = contentCreator.createContent(employees);
//        try {
//            mailApi.sendMail("give4me2pain@gmail.com", "Text", content);
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//        return "greeting.html";
//    }

    //spring mvc

    @PostMapping("/post_request")
    public String post3423(List<Employee> employees) {


        String content = contentCreator.createContent(employees);
        try {
            mailApi.sendMail("give4me2pain@gmail.com", "Text", content);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "greeting.html";
    }


//    @RequestMapping(value = "/" , method = RequestMethod. POST)

    @PostMapping("/send")
    public String  editCustomer(@ModelAttribute("employeeContainer") EmployeeContainer employeeContainer)    {
        List<Employee> employees = employeeContainer.getEmployees();
        String content = contentCreator.createContent(employees);
        try {
            mailApi.sendMail("give4me2pain@gmail.com", "Text", content);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "greeting.html";
    }
//        List<Employee> employees = employeeProvider.getEmployees();

}
