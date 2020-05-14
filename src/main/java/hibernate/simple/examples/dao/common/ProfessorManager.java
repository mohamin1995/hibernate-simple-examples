package hibernate.simple.examples.dao.common;

import java.util.List;

import hibernate.simple.examples.entity.Professor;

public interface ProfessorManager {
	
	public void saveProfessor(Professor professor);
	public List<Professor> getProfessors();
	public Professor getProfessor(Integer id);
	public void updateProfessor(Professor professor);

}
