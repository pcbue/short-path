package fr.shortpath.back.service;

import java.util.Optional;

import fr.shortpath.back.data.Producer;
import fr.shortpath.back.repository.ProducerRepository;
import org.elasticsearch.common.base.Strings;

public class ProducerService {

    private final ProducerRepository repository;

    public ProducerService(ProducerRepository repository) {
        this.repository = repository;
    }

    // TODO suggest results

    public Optional<Producer> findByLogin(String login) {
        if (Strings.isNullOrEmpty(login)) {
            return Optional.ofNullable(repository.findByLogin(login));
        } else {
            return Optional.empty();
        }
    }
}
