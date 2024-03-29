package org.vermaproject.apps.server.db.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.vermaproject.apps.server.enums.TicketEventEnum;
import org.vermaproject.apps.server.utils.converters.TicketEventConverter;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

@Table(name = "repair_events")
@Entity(name = "TicketEvent")
@ToString
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class TicketEvent implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Convert(converter = TicketEventConverter.class)
    private TicketEventEnum ticketEvent;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ticket ticket;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Builder.Default
    private ZonedDateTime eventTimestamp = ZonedDateTime.now();
}
