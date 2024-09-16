package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_production")
public class VehicleProduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Modelss modelss;

    @Column(nullable = false)
    private double year_of_manufacture;

    private String color;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Modelss getCategories() {
        return modelss;
    }

    public void setCategories(Modelss modelss) {
        this.modelss = modelss;
    }

    public double getYear_of_manufacture() {
        return year_of_manufacture;
    }

    public void setYear_of_manufacture(double year_of_manufacture) {
        this.year_of_manufacture = year_of_manufacture;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
