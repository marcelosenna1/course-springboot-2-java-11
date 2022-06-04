package com.devsena.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.devsena.course.entities.User;
import com.devsena.course.repositories.UserRepository;
import com.devsena.course.services.exceptions.DataBaseException;
import com.devsena.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@GetMapping
	public List<User> findAll() {
		return repository.findAll();
	}

	public Optional<User> findById(Long id) {

		return Optional.of(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id)));

	}

	public User insert(User obj) {

		return repository.save(obj);
	}

	public void delete(Long id) {

		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}

	}

	public User update(long id, User obj) {

		@SuppressWarnings("deprecation")
		User entity = repository.getById(id);

		upDateData(entity, obj);

		return repository.save(entity);

	}

	private void upDateData(User entity, User obj) {

		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}
}
