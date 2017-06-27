package javaee.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javaee.sample.data.annotation.Artist;
import javaee.sample.data.annotation.Genre;
import javaee.sample.data.annotation.Price;
import javaee.sample.data.annotation.Title;

/**
 * Represents tune model
 *
 */
@Entity
@XmlRootElement
@Table(name = "tunes")
@NamedQueries({ @NamedQuery(name = Tune.ALL, query = "SELECT tun FROM Tune AS tun"),
		@NamedQuery(name = Tune.BY_GENRE, query = "SELECT tun FROM Tune AS tun WHERE tun.genre = :genre"),
		@NamedQuery(name = Tune.BY_ARTIST, query = "SELECT tun FROM Tune AS tun WHERE tun.artist = :artist") })
public class Tune {

	public static final String ALL = "tunesAll";

	public static final String BY_GENRE = "tunesByGenre";

	public static final String BY_ARTIST = "tunesByArtist";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Artist
	@Column(name = "artist")
	private String artist;

	@Title
	@Column(name = "title")
	private String title;

	@Genre
	@Column(name = "genre")
	private String genre;

	@Price
	@Column(name = "price")
	private double price;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).addValue(getId()).addValue(getTitle()).addValue(getGenre())
				.addValue(getArtist()).addValue(getPrice()).toString();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId(), getArtist(), getTitle(), getGenre(), getPrice());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		final Tune other = (Tune) obj;
		return Objects.equal(getId(), other.getId()) && Objects.equal(getTitle(), other.getTitle())
				&& Objects.equal(getGenre(), other.getGenre()) && Objects.equal(getArtist(), other.getArtist())
				&& Objects.equal(getPrice(), other.getPrice());
	}
}
