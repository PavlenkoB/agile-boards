package ua.com.mycompany.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.lang.reflect.Member;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.05.2018
 * Project: agile-boards
 */
public interface BoardRepository extends MongoRepository<Member, Long> {
}
