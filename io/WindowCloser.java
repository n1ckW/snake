package io;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import launcher.Launcher;

public class WindowCloser implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		Launcher.terminate();
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

}
