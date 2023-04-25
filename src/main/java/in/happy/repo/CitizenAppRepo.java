package in.happy.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.happy.entity.CitizenApp;

public interface CitizenAppRepo extends JpaRepository<CitizenApp,Serializable> {

}
