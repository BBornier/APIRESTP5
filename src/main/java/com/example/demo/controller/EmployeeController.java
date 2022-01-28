package com.example.demo.controller;

import com.example.demo.dto.IdDTO;
import com.example.demo.dto.NameDTO;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> all() {
        return employeeService.returnAllEmployeesInDataBase();
    }

    @GetMapping("/characters/{id}")
    public Employee solo(@PathVariable Long id) {
        return employeeService.returnEmployeeByHisId(id);
    }

    @GetMapping("/character/{name}")
    public Employee name(@PathVariable String name) {
        return employeeService.returnEmployeeByHisName(name);
    }

    @PostMapping("/employee")
    public String create(@RequestBody Employee exemple) {
       employeeService.createAnEmployee(exemple);
        return "An Employee created ! congrats !";
    }

    @PostMapping("/characters")
    public List<Employee> createSeveralEmployees(@RequestBody List<Employee> exemple2) {
        return employeeService.saveAllEmployeesInDataBase(exemple2);
    }

    @DeleteMapping("/employees")
        public String deleteAll() {
            employeeService.deleteAllEmployees();
            return "All Employees are deleted";
    }

    @PutMapping("/updateCharacter/{id}")
    public Employee updateACharacter(@RequestBody Employee update, @PathVariable Long id) {
        return employeeService.updateACharacterById(update, id);
    }

    @PutMapping("/updateCharacterName/{naaaaame}")
    public Employee updateACharacterBHisFuckingName(@RequestBody Employee updateName, @PathVariable String naaaaame) {
        return employeeService.updateACharcaterByHisName(updateName, naaaaame);
    }

    @GetMapping("/charact/{role}")
    public List<Employee> findCharactersByItsRoles(@PathVariable ("role") String leRolequIlAimeBien) {
        return employeeService.findACharacterByHisRole(leRolequIlAimeBien);
    }

    @GetMapping("/charact/")
    public List<Employee> findCharactersByItsRole(@RequestParam String role) {
        return  employeeService.findACharacterByHisRole(role);
    }

    @GetMapping("/charactName/")
    public List<NameDTO> findCharactByHisNameDTO(@RequestParam String role) {
        return employeeService.returnCharacterByHisNameDTO(role);
    }

    @GetMapping("/zoudesbizousId/")
    public List<IdDTO> findCharacterByHisIdDTO(@RequestParam String role) {
        return employeeService.returnCharacterByHisIdDTO(role);
    }

}
