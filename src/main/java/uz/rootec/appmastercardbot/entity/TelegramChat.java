package uz.rootec.appmastercardbot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

/**
 * Created by Sherlock on 25.06.2021.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TelegramChat {
    @Id
    private UUID id;

    @Column(nullable = false,unique = true)
    private Long chatId;
}
