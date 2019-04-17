package graph

import org.scalatest._

class GraphSpec extends FunSpec with Matchers {
  describe("Graphs") {
    it("P80 (***) Conversions.") {
      Graph.fromString("[b-c, f-c, g-h, d, f-b, k-f, h-g]").toTermForm shouldBe (List(d, k, h, c, f, g, b),List((h,g,()), (k,f,()), (f,b,()), (g,h,()), (f,c,()), (b,c,())))
      Digraph.fromStringLabel("[p>q/9, m>q/7, k, p>m/5]").toAdjacentForm shouldBe List((m,List((q,7))), (p,List((m,5), (q,9))), (k,List()), (q,List()))
    }
    it("P81 (**) Path from one node to another one.") {
      Digraph.fromStringLabel("[p>q/9, m>q/7, k, p>m/5]").findPaths("p", "q") shouldBe List(List(p, q), List(p, m, q))
      Digraph.fromStringLabel("[p>q/9, m>q/7, k, p>m/5]").findPaths("p", "k") shouldBe List()

    }
    it("P82 (*) Cycle from a given node.") {
      Graph.fromString("[b-c, f-c, g-h, d, f-b, k-f, h-g]").findCycles("f") shouldBe List(List(f, c, b, f), List(f, b, c, f))

    }
    it("P83 (**) Construct all spanning trees.") {
      val graph = Graph.term(List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'),
        List(('a', 'b'), ('a', 'd'), ('b', 'c'), ('b', 'e'),
          ('c', 'e'), ('d', 'e'), ('d', 'f'), ('d', 'g'),
          ('e', 'h'), ('f', 'g'), ('g', 'h')))
      graph.fromString("[a-b, b-c, a-c]").spanningTrees shouldBe List([a-b, b-c], [a-c, b-c], [a-b, a-c])
    }
    it("P84 (**) Construct the minimal spanning tree.") {
      val graph = Graph.termLabel(
        List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'),
        List(('a', 'b', 5), ('a', 'd', 3), ('b', 'c', 2), ('b', 'e', 4),
          ('c', 'e', 6), ('d', 'e', 7), ('d', 'f', 4), ('d', 'g', 3),
          ('e', 'h', 5), ('f', 'g', 4), ('g', 'h', 1)))
      graph.fromStringLabel("[a-b/1, b-c/2, a-c/3]").minimalSpanningTree shouldBe [a-b/1, b-c/2]
    }
    it("P85 (**) Graph isomorphism.") {
      Graph.fromString("[a-b]").isIsomorphicTo(Graph.fromString("[5-7]")) shouldBe true
    }
    describe("P86 (**) Node degree and graph coloration.") {
      it("a) Write a method Node.degree that determines the degree of a given node."){

      Graph.fromString("[a-b, b-c, a-c, a-d]").nodes("a").degree shouldBe 3
      }
      it("b) Write a method that lists all nodes of a graph sorted according to decreasing degree.") {
        Graph.fromString("[a-b, b-c, a-c, a-d]").nodesByDegree shouldBe List(Node(a), Node(c), Node(b), Node(d))
      }
      it("c) Use Welsh-Powell's algorithm to paint the nodes of a graph in such a way that adjacent nodes have different colors. Make a method colorNodes that returns a list of tuples, each of which contains a node and an integer representing its color."){
        Graph.fromString("[a-b, b-c, a-c, a-d]").colorNodes shouldBe List((Node(a),1), (Node(b),2), (Node(c), 3), (Node(d), 2))
      }

    }
    it("P87 (**) Depth-first order graph traversal.") {
      Graph.fromString("[a-b, b-c, e, a-c, a-d]").nodesByDepthFrom("d") shouldBe List(c, b, a, d)
    }
    it("P88 (**) Connected components.") {
      Graph.fromString("[a-b, c]").splitGraph shouldBe List([a-b], [c])

    }
    it("P89 (**) Bipartite graphs.") {
      Digraph.fromString("[a>b, c>a, d>b]").isBipartite shouldBe true
      Graph.fromString("[a-b, b-c, c-a]").isBipartite shouldBe false
      Graph.fromString("[a-b, b-c, d]").isBipartite shouldBe true
      Graph.fromString("[a-b, b-c, d, e-f, f-g, g-e, h]").isBipartite shouldBe false
    }
  }
}
