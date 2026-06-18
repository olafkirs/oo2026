import React, { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

const API_URL = process.env.REACT_APP_API_URL;

function ExternalBooks() {
  const [books, setBooks] = useState([]);
  const [page, setPage] = useState(1);
  const [error, setError] = useState("");

  useEffect(() => {
    async function fetchExternal() {
      setError("");
      try {
        // Paring laheb meie OMA back-endi, mitte otse itbook.store-i
        const res = await fetch(`${API_URL}/api/external/books?page=${page}`);
        const data = await res.json();
        if (!res.ok || data.error) {
          setBooks([]);
          setError(data.error || "Välise API-ga ei saanud ühendust.");
          return;
        }
        setBooks(data.books || []);
      } catch (e) {
        setBooks([]);
        setError("Välise API-ga ei saanud ühendust.");
      }
    }
    fetchExternal();
  }, [page]);

  return (
    <div className="container mt-4" style={{ minHeight: "100vh", padding: "20px" }}>
      <h2 className="text-center mb-4">Raamatud välisest API-st (itbook.store)</h2>

      {error && (
        <div className="alert alert-warning text-center">
          {error}
        </div>
      )}

      <div className="row">
        {books.map((book) => (
          <div className="col-md-3 mb-4" key={book.isbn13}>
            <div className="card h-100 shadow-sm">
              <img
                src={book.image}
                alt={book.title}
                className="card-img-top"
                style={{ height: "220px", objectFit: "contain", padding: "10px" }}
              />
              <div className="card-body">
                <h6 className="card-title">{book.title}</h6>
                <p className="card-text" style={{ fontSize: "0.8rem", color: "#666" }}>
                  {book.subtitle}
                </p>
                <p className="fw-bold">{book.price}</p>
                <a href={book.url} target="_blank" rel="noreferrer" className="btn btn-sm btn-dark">
                  Vaata
                </a>
              </div>
            </div>
          </div>
        ))}
      </div>

      {/* Pagination */}
      <div className="d-flex justify-content-center align-items-center gap-3 mt-3">
        <button className="btn btn-dark" disabled={page === 1} onClick={() => setPage((p) => p - 1)}>
          ← Eelmine
        </button>
        <span>Lehekülg {page}</span>
        <button className="btn btn-dark" onClick={() => setPage((p) => p + 1)}>
          Järgmine →
        </button>
      </div>
    </div>
  );
}

export default ExternalBooks;
