package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.repository.CreatureRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatureService {

    private final CreatureRepository repository;

    public CreatureService(CreatureRepository repository) {this.repository = repository;}
}
