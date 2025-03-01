package ru.mts.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ru.mts.entity.JustUser;

@ApplicationScoped
public class JustUserRepository implements PanacheRepository<JustUser> {
}
