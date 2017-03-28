package by.mantur.port.entity;

import java.util.concurrent.atomic.AtomicBoolean;

public class Pier {

	private String name;
	private AtomicBoolean busy = new AtomicBoolean(false);

	public Pier(int i) {
		name = String.format("Dock#%d", i);
	}

	public boolean isBusy() {
		return busy.get();
	}

	public void occupyPier() {
		busy.set(true);
	}

	public void releasePier() {
		busy.set(false);
	}

	@Override
	public String toString() {
		return name;
	}

}
