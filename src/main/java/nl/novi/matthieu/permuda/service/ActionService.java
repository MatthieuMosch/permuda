package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.repository.ActionRepository;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

    private final ActionRepository repository;

    public ActionService(ActionRepository repository) {this.repository = repository;}
}
