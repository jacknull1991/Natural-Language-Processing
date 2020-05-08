# A Natural Language Interface to PostgreSQL Database

### How it works.
1. Parse the input and map nodes to SQL components and preset database attributes.

2. Adjust the structure of the parse tree to make it syntactically valid.

3. Translate the parse tree to an SQL query.

******

### Grammar rules of syntactically valid parse tree

1. Q -> (SClause)(ComplexCondition)\*
2. SClause -> SELECT + GNP
3. ComplexCondition -> ON + (leftSubtree\*rightSubtree)
4. leftSubtree -> GNP
5. rightSubtree -> GNP | VN | MIN | MAX
6. GNP -> (FN + GNP) | NP
7. NP -> NN + (NN)\*(condition)\*
8. condition -> VN | (ON + VN)