package com.google.solution.accident.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccidentRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "test-sequence-generator")
    @GenericGenerator(
            name = "test-sequence-generator",
            strategy = "sequence",
            parameters = {
                    @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = SequenceStyleGenerator.DEF_SEQUENCE_NAME),
                    @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
                    @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1000"),
                    @Parameter(name = AvailableSettings.PREFERRED_POOLED_OPTIMIZER, value = "pooled-lo")
            }
    )
    private Long id;

    private String severity;

    private double startLat;

    private double startLng;

    private double endLat;

    private double endLng;

    private double distance;

    private String description;

    @Enumerated(EnumType.STRING)
    private State state;

    public AccidentRegion(String severity, double startLat, double startLng, double endLat, double endLng, double distance, String description, State state) {
        this(null, severity, startLat, startLng, endLat, endLng, distance, description, state);
    }

    private AccidentRegion(Long id, String severity, double startLat, double startLng, double endLat, double endLng, double distance, String description, State state) {
        this.id = id;
        this.severity = severity;
        this.startLat = startLat;
        this.startLng = startLng;
        this.endLat = endLat;
        this.endLng = endLng;
        this.distance = distance;
        this.description = description;
        this.state = state;
    }
}
