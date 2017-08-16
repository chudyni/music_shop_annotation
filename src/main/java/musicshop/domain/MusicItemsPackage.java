package musicshop.domain;

import java.util.List;

import musicshop.domain.item.MusicItem;

public class MusicItemsPackage {

	private List<? extends MusicItem> items;
	private String name;

	public List<? extends MusicItem> getItems() {
		return items;
	}

	public void setItems(List<? extends MusicItem> items) {
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
