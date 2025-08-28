package com.habitTracker.ArchitectureClean.core.domain;

import com.habitTracker.ArchitectureClean.core.enums.StatusCheckIn;

import java.time.LocalDate;
import java.util.Objects;

public class CheckIn {
    private final Long id;
    private LocalDate data;
    private StatusCheckIn status;
    private final Long habitoId;

    public CheckIn(Long id, LocalDate data, StatusCheckIn status, Long habitoId){
        this.id = id;
        this.data = data;
        this.status = status;
        this.habitoId = habitoId;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public StatusCheckIn getStatus() {
        return status;
    }

    public Long getHabitoId() {
        return habitoId;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setStatus(StatusCheckIn status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckIn checkIn = (CheckIn) o;
        return Objects.equals(id, checkIn.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
