package resourceManager;

public class LockResourceManager extends BasicResourceManager {
    /**
     * Set the resource and initialise the numbers of waiting processes, and the number of users, to zero.
     *
     * @param resource the resource managed by this manager
     * @param maxUses  the maximum number of uses permitted for this manager's resource.
     */
    public LockResourceManager(Resource resource, int maxUses) {
        super(resource, maxUses);
    }

    @Override
    public void requestResource(int priority) throws ResourceError {

    }

    @Override
    public int releaseResource() throws ResourceError {
        return 0;
    }
}
