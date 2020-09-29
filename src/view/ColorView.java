package view;

import controller.ColorController;

public abstract class ColorView {

	/**
	 * @param controller
	 *            The color controller being updated.
	 * @param caller
	 *            The object updating the color.
	 */
	public abstract void update(ColorController controller, Object caller);

}
