package com.dailyquest.dailyquest.notification.dto;

import com.dailyquest.dailyquest.notification.preference.NotificationPreferenceModel;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class NotificationPreferenceDTOMapper implements
        Function<NotificationPreferenceModel, NotificationPreferenceDTO> {

    @Override
    public NotificationPreferenceDTO apply(NotificationPreferenceModel notificationPreferenceModel) {
        return new NotificationPreferenceDTO(
                notificationPreferenceModel.getId(),
                notificationPreferenceModel.getChannel(),
                notificationPreferenceModel.getFrequency(),
                notificationPreferenceModel.getLeadTimeMinutes(),
                notificationPreferenceModel.getQuietHoursStart(),
                notificationPreferenceModel.getQuietHoursEnd(),
                notificationPreferenceModel.isEnabled()
        );
    }
}
