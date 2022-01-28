package com.example.demo.service;

import com.example.demo.dto.IdDTO;
import com.example.demo.dto.NameDTO;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> returnAllEmployeesInDataBase() {
        return employeeRepository.findAll();
    }

    public Employee returnEmployeeByHisId(Long id) {

        return employeeRepository.findById(id).get();
    }

    public Employee returnEmployeeByHisName(String name) {

        return employeeRepository.findByName(name);
    }

    public void deleteAllEmployees() {

        employeeRepository.deleteAll();
    }

    public Employee createAnEmployee(Employee newCharacter) {

        return employeeRepository.save(newCharacter);
    }

    public List<Employee> saveAllEmployeesInDataBase(List<Employee> allCharacters) {
        return employeeRepository.saveAll(allCharacters);
    }

    public Employee updateACharacterById(Employee anotherCharacterLuluMonCul, Long idFix) {
        Employee unNomEtBisou = employeeRepository.findById(idFix).get();
        unNomEtBisou.setRole(anotherCharacterLuluMonCul.getRole());
        return employeeRepository.save(unNomEtBisou);
    }

    public Employee updateACharcaterByHisName(Employee pierre, String nemChinoise) {
        Employee paul = employeeRepository.findByName(nemChinoise);
        paul.setName(pierre.getName());
        return employeeRepository.save(paul);
    }

    public List<Employee> findACharacterByHisRole(String role) {
        return employeeRepository.findAllByRole(role);
    }

    public List<NameDTO> returnCharacterByHisNameDTO(String role) {
        List<Employee> allEmployeesEntity = employeeRepository.findAllByRole(role);
        List<NameDTO> byName = new ArrayList<>();

        for (Employee perso : allEmployeesEntity) {
            NameDTO namedto = new NameDTO();
            namedto.setName(perso.getName());
            byName.add(namedto);
        }
        return byName;
    }

    public List<IdDTO> returnCharacterByHisIdDTO(String role) {
        List<Employee> allEmployeesEntity = employeeRepository.findAllByRole(role);
        List<IdDTO> byId = new ArrayList<>();

        for (Employee perso2 : allEmployeesEntity) {
            IdDTO idDto = new IdDTO();
            idDto.setId(perso2.getId());
            byId.add(idDto);
        }
        return byId;
    }

}
