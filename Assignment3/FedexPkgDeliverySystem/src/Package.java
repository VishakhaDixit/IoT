public class Package {
    // Details provided by user
    private String weight;
	private String dimensions;
	private int pieces;
	private String src, dest;
    private String currLocation; 
    private String signServices; 
    private String packaging;
    private String specialHandling; 
    private String service;

    // Detail generated by Fedex
	public String trackingNo;           // User has access to this item for tracking purposes

    Package(String weight, String dimensions, int pieces, String src, String dest, String signServices, 
            String packaging, String specialHandling, String service) 
    {
		this.weight = weight;
		this.dimensions = dimensions;
		this.pieces = pieces;
		this.src = src;
		this.dest = dest;
		this.signServices = signServices;
		this.packaging = packaging;
		this.specialHandling = specialHandling;
		this.service = service;
	}

    // Setter & Getter Methods for each Package detail
    public void setWeight(String w)
    {
        weight = w;
    }
    public void setDimensions(String dim) 
    {
        dimensions = dim;
    }
    public void setTotalPieces(int tp)
    {
        pieces = tp;
    }
    public void setSrc(String source)
    {
        src = source;
    }
    public void setDest(String destination)
    {
        dest = destination;
    }
    public void setCurrLocation(String location) 
    {
        currLocation = location;
    }
    public void setSignServices(String signSvc)
    {
        signServices = signSvc;
    }
    public void setPackaging(String pckg)
    {
        packaging = pckg;
    }
    public void setSpecialHandlingSrvc(String sh)
    {
        specialHandling = sh;
    }
    public void setService(String srvc)
    {
        service = srvc;
    }

    public String getWeight()
    {
        return weight;
    }
    public String getDimensions() 
    {
        return dimensions;
    }
    public int getTotalPieces()
    {
        return pieces;
    }
    public String getSrc()
    {
        return src;
    }
    public String getDest()
    {
        return dest;
    }
    public String getCurrLocation() 
    {
        return currLocation;
    }
    public String getSignServices()
    {
        return signServices;
    }
    public String getPackaging()
    {
        return packaging;
    }
    public String getSpecialHandlingSrvc()
    {
        return specialHandling;
    }
    public String getService()
    {
        return service;
    }
}
