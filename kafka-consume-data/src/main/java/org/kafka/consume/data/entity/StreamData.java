package org.kafka.consume.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "media_recentchange")
public class StreamData {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWikiEventData() {
		return wikiEventData;
	}

	public void setWikiEventData(String wikiEventData) {
		this.wikiEventData = wikiEventData;
	}

	@Lob
    private String wikiEventData;
	
}
