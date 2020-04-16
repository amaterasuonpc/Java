package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Albums", schema = "public", catalog = "MusicAlbums")
@NamedQueries({@NamedQuery(name="Album.findByName",query="select a from Album a where a.name=:name"),@NamedQuery(name="Album.findByArtist",query="select a from Album a where a.artist_id=:artistid")})
public class Album {
    private int id;
    private String name;
    private Integer releaseYear;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "release_year")
    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album that = (Album) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(releaseYear, that.releaseYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, releaseYear);
    }
}
