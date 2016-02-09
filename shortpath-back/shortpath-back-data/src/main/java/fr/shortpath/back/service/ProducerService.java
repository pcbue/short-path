package fr.shortpath.back.service;

import java.util.Optional;

import fr.shortpath.back.data.Producer;
import fr.shortpath.back.repository.ProducerRepository;
import org.elasticsearch.common.base.Strings;
import org.springframework.beans.factory.annotation.Required;

public class ProducerService {

    private ProducerRepository repository;

    @Required
    public void setRepository(ProducerRepository repository) {
        this.repository = repository;
    }

    public Optional<Producer> findByLogin(String login) {
        if (Strings.isNullOrEmpty(login)) {
            return Optional.ofNullable(repository.findByLogin(login));
        } else {
            return Optional.empty();
        }
    }
}
