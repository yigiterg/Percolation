# Percolation

Note that you need to build algs4.jar file in the project to make this project works in IntelliJ IDEA.

Princeton University Algorithms Part I Week I 

Percolation. Given a composite systems comprised of randomly distributed insulating and metallic materials: what fraction of the materials need to be metallic so that the composite system is an electrical conductor? Given a porous landscape with water on the surface (or oil below), under what conditions will the water be able to drain through to the bottom (or the oil to gush through to the surface)? Scientists have defined an abstract process known as percolation to model such situations.

The model. We model a percolation system using an n-by-n grid of sites. Each site is either open or blocked. A full site is an open site that can be connected to an open site in the top row via a chain of neighboring (left, right, up, down) open sites. We say the system percolates if there is a full site in the bottom row. In other words, a system percolates if we fill all open sites connected to the top row and that process fills some open site on the bottom row. (For the insulating/metallic materials example, the open sites correspond to metallic materials, so that a system that percolates has a metallic path from top to bottom, with full sites conducting. For the porous substance example, the open sites correspond to empty space through which water might flow, so that a system that percolates lets water fill open sites, flowing from top to bottom.)
![](https://user-images.githubusercontent.com/55719720/90126601-9a1cb300-dd6c-11ea-94f9-49fa65be139c.JPG)
![](https://user-images.githubusercontent.com/55719720/90126760-d4865000-dd6c-11ea-96bb-d91448777e40.JPG)
![](https://user-images.githubusercontent.com/55719720/90126860-fd0e4a00-dd6c-11ea-8545-be082d76b925.JPG)
![](https://user-images.githubusercontent.com/55719720/90126961-1dd69f80-dd6d-11ea-92ef-b3b4b6e242a9.JPG)
![](https://user-images.githubusercontent.com/55719720/90127060-43fc3f80-dd6d-11ea-8139-e7d70183074d.JPG)


