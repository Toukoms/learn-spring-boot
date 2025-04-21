package com.example.training.service;

import com.example.training.data.entity.EmployeeEntity;
import com.example.training.data.entity.Position;
import com.example.training.data.repository.EmployeeRepository;
import com.example.training.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        List<EmployeeEntity> employeeEntities = this.employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>(employeeEntities.size());
        employeeEntities.forEach(e -> employees.add(this.getEmployeeFromEmployeeEntity(e)));
        return employees;
    }

    public Employee getEmployeeById(UUID id) {
        return this.getEmployeeFromEmployeeEntity(this.employeeRepository.getReferenceById(id));
    }

    public Employee addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = this.getEmployeeEntityFromEmployee(employee);
        return this.getEmployeeFromEmployeeEntity(this.employeeRepository.save(employeeEntity));
    }

    public Employee updateEmployee(UUID id, Employee employee) {
        employee.setId(id);
        EmployeeEntity employeeEntity = this.getEmployeeEntityFromEmployee(employee);
        return this.getEmployeeFromEmployeeEntity(this.employeeRepository.save(employeeEntity));
    }

    public void deleteEmployee(UUID id) {
        this.employeeRepository.deleteById(id);
    }

    private Employee getEmployeeFromEmployeeEntity(EmployeeEntity employeeEntity) {
        return new Employee(employeeEntity.getEmployeeId(), employeeEntity.getFirstName(), employeeEntity.getLastName(), employeeEntity.getPosition().toString());
    }

    private EmployeeEntity getEmployeeEntityFromEmployee(Employee employee) {
        return new EmployeeEntity(employee.getId(), employee.getFirstName(), employee.getLastName(), Position.valueOf(employee.getPosition()));
    }
}
