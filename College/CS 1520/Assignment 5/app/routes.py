from app import app, api
from flask import Flask, render_template, json
from flask_restful import Resource, Api, reqparse, abort

cats = {"-1": {"cat":"", "budget":0}}   # {"cat_id": {"cat": "...", "budget": "..."}, ...}
purchases = {}   # {"purchase_id": {"item": "...", "cost": "...", "date": "...", "cat_id": "..."}, ...}
parser = reqparse.RequestParser()
parser.add_argument('cat')
parser.add_argument('cat_id')
parser.add_argument('purchase')
parser.add_argument('purchase_id')

class Categories(Resource):
    def get(self):
        return cats

    def post(self):
        p = parser.copy()
        p.replace_argument('cat', required=True, help='Must supply a category in the form of {"cat": "<categoryName>", "budget": "<budget>"}')
        args = p.parse_args()
        cat_id = 0
        while str(cat_id) in cats:
            cat_id += 1
        cat_id = str(cat_id)
        cat_value = json.loads(args['cat'].replace("\'", "\""))
        if cat_value["cat"] in [cats[cat]["cat"] for cat in cats]:
            abort(400, message="Category {} already exits".format(cat_value["cat"]))
        cats[cat_id] = cat_value
        return cats[cat_id], 201

    def delete(self):
        p = parser.copy()
        p.replace_argument('cat_id', type=int, required=True, help='Must supply a category ID in the form of {"cat_id": "<categoryId>"}')
        args = p.parse_args()
        cat_id = args['cat_id']
        if cat_id not in cats:
            abort(404, message="Category ID {} does not exist".format(cat_id))
        del cats[cat_id]
        return '', 204

class Category(Resource):
    def get(self, cat_id):
        if cat_id not in cats:
            abort(404, message="Category ID {} does not exist".format(cat_id))
        return cats[cat_id]

    def post(self, cat_id):
        if cat_id in cats:
            abort(400, message="Category ID {} already exits".format(cat_id))
        p = parser.copy()
        p.replace_argument('cat', required=True, help='Must supply a category in the form of {"cat": "<categoryName>", "budget": "<budget>"}')
        args = p.parse_args()
        cat_value = json.loads(args['cat'].replace("\'", "\""))
        if cat_value["cat"] in [cats[cat]["cat"] for cat in cats]:
            abort(400, message="Category {} already exits".format(cat_value["cat"]))
        cats[cat_id] = cat_value
        return cats[cat_id], 201

    def delete(self, cat_id):
        if cat_id not in cats:
            abort(404, message="Category ID {} does not exist".format(cat_id))
        del cats[cat_id]
        return '', 204

class Purchases(Resource):
    def get(self):
        return purchases

    def put(self):
        p = parser.copy()
        p.replace_argument('purchase', required=True, help='Must supply a purchase in the form of {"purchase_id": {"item": "<itemName>", "cost": "<cost>", "date": "<date>", "cat_id": "<categoryId>"}}')
        args = p.parse_args()
        purchase_json = json.loads(args['purchase'].replace("\'", "\""))
        purchase_value = purchase_json[purchase]
        purchases[purchase_id] = purchase_value
        return purchases[purchase_id], 201

    def delete(self):
        p = parser.copy()
        p.replace_argument('purchase_id', type=int, required=True, help='Must supply a purchase ID in the form of {"purchase_id": "<purchaseId>"}')
        args = p.parse_args()
        purchase_id = args['purchase_id']
        if purchase_id not in purchases:
            abort(404, message="Purchase ID {} does not exist".format(purchase_id))
        del purchases[purchase_id]
        return '', 204

class Purchase(Resource):
    def get(self, purchase_id):
        if purchase_id not in purchases:
            abort(404, message="Purchase ID {} does not exist".format(purchase_id))
        return purchases[purchase_id]

    def put(self, purchase_id):
        if purchase_id in purchases:
            abort(400, message="Purchase ID {} already exits".format(purchase_id))
        p = parser.copy()
        p.replace_argument('purchase', required=True, help='Must supply a purchase in the form of {"item": "<itemName>", "cost": "<cost>", "date": "<date>", "cat_id": "<categoryId>"}')
        args = p.parse_args()
        purchase_value = json.loads(args['purchase'].replace("\'", "\""))
        purchases[purchase_id] = purchase_value
        return purchases[purchase_id], 201

    def delete(self, purchase_id):
        if purchase_id not in purchases:
            abort(404, message="Purchase ID {} does not exist".format(purchase_id))
        del purchases[purchase_id]
        return '', 204

api.add_resource(Categories, '/cats')
api.add_resource(Category, '/cats/<cat_id>')
api.add_resource(Purchases, '/purchases')
api.add_resource(Purchase, '/purchases/<purchase_id>')


@app.route('/', methods=["GET"])
def main():
    return render_template("main.html", title="Budget")
