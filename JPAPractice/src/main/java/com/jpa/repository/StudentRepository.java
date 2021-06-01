package com.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.vo.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	Optional<Student> findBySchool(String schoolNm);
}
