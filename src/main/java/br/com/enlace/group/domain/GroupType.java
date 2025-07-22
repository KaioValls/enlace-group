package br.com.enlace.group.domain;

public enum GroupType {
    CELL("Célula"),
    TEAM("Equipe"),
    MINISTRY("Ministério"),
    DEPARTMENT("Departamento"),
    COMMITTEE("Comitê"),
    PRAYER_GROUP("Grupo de Oração"),
    generic("Genérico");

    private final String description;

    GroupType(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
