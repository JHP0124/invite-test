package io.playdata.dao;

import org.springframework.data.repository.CrudRepository;

import io.playdata.domain.Board;
/* CrudRepository를 상속받아 기본적인 CRUD 작업 가능. 문법은 검색 확인 필요.
 * 사용자에게 더 맞게 사용하려면 JpaRepository를 이용해 페이징 등의 작업 가능함. */
public interface BoardRepository extends CrudRepository<Board, Long> {

}
