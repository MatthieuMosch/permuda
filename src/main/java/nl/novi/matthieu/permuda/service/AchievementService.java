package nl.novi.matthieu.permuda.service;

import nl.novi.matthieu.permuda.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AchievementService {

    private final UserRepository repository;

    public AchievementService(UserRepository repository) {this.repository = repository;}
}
