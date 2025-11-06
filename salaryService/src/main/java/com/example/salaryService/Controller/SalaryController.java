package com.example.salaryService.Controller;


import com.example.salaryService.entity.Salary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salaries")
public class SalaryController {

    private static final List<Salary> salaries = List.of(
            new Salary(101, 50000, 5000),
            new Salary(102, 40000, 3000)
    );

    @GetMapping("/all")
    public List<Salary> getAllSalaries() {
        System.out.println("++++++all salary called++++++++++++++++++++++++++++++++++++++++++++++");
        return salaries;
    }

    @GetMapping("/{id}")
    public Salary getSalaryById(@PathVariable int id) {
        System.out.println("++++++++++++++ID:::: salary called +++++++");
        return salaries.stream()
                .filter(s -> s.getEmpId() == id)
                .findFirst()
                .orElse(null);
    }
}
