package com.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.api.entity.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TaskRepository extends CrudRepository<Task, Long> {
	

	@Query("SELECT t FROM Task t WHERE t.id = :taskId")
    Task findTaskById(@Param("taskId") Long taskId);

    @Modifying
    @Transactional
    @Query("UPDATE Task t SET t.title = :title, t.description = :description, t.completed = :completed WHERE t.id = :taskId")
    void updateTask(@Param("taskId") Long taskId, @Param("title") String title, @Param("description") String description, @Param("completed") boolean completed);

    @Modifying
    @Transactional
    @Query("DELETE FROM Task t WHERE t.id = :taskId")
    void deleteTaskById(@Param("taskId") Long taskId);
    
 
}