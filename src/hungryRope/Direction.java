package hungryRope;

/**
 * Stores axis, and the positive or negative movement along the axis
 */
public class Direction
{
    char axis;
    int posOrNeg;

    /**
     * Creates a new Direction
     * @param axis axis of movement
     * @param posOrNeg direction along axis
     */
    Direction (char axis, int posOrNeg)
    {
        this.axis = axis;
        this.posOrNeg = posOrNeg;
    }

    /**
     * Checks if two Directions are equal to each other
     * @param direction2 direction to compare to
     * @return Whether the Direction is equal to the other Direction
     */
    public boolean equals(Direction direction2)
    {
        return (this.axis == direction2.axis && this.posOrNeg == direction2.posOrNeg);
    }
}
