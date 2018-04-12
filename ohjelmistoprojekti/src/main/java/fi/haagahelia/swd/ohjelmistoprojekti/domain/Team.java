package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long team_id;
}
